package net.icefighter.icesmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.icefighter.icesmod.world.inventory.SummonBookMenu;
import net.icefighter.icesmod.network.SummonBookButtonMessage;
import net.icefighter.icesmod.IcesModMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SummonBookScreen extends AbstractContainerScreen<SummonBookMenu> {
	private final static HashMap<String, Object> guistate = SummonBookMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox AmethystBook;
	Button button_empty;

	public SummonBookScreen(SummonBookMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		AmethystBook.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (AmethystBook.isFocused())
			return AmethystBook.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		AmethystBook.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String AmethystBookValue = AmethystBook.getValue();
		super.resize(minecraft, width, height);
		AmethystBook.setValue(AmethystBookValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		AmethystBook = new EditBox(this.font, this.leftPos + 25, this.topPos + 80, 118, 18, Component.translatable("gui.ices_mod.summon_book.AmethystBook")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.ices_mod.summon_book.AmethystBook").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.ices_mod.summon_book.AmethystBook").getString());
				else
					setSuggestion(null);
			}
		};
		AmethystBook.setSuggestion(Component.translatable("gui.ices_mod.summon_book.AmethystBook").getString());
		AmethystBook.setMaxLength(32767);
		guistate.put("text:AmethystBook", AmethystBook);
		this.addWidget(this.AmethystBook);
		button_empty = Button.builder(Component.translatable("gui.ices_mod.summon_book.button_empty"), e -> {
			if (true) {
				IcesModMod.PACKET_HANDLER.sendToServer(new SummonBookButtonMessage(0, x, y, z));
				SummonBookButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 150, this.topPos + 79, 25, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
	}
}
