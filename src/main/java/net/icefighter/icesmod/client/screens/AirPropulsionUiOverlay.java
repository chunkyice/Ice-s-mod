
package net.icefighter.icesmod.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.icefighter.icesmod.procedures.Displaypropulsion3Procedure;
import net.icefighter.icesmod.procedures.Displaypropulsion2Procedure;
import net.icefighter.icesmod.procedures.DisplayPropulsion1Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class AirPropulsionUiOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (true) {
			if (DisplayPropulsion1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("ices_mod:textures/screens/jump1.1.png"), w / 2 + -5, h / 2 + 14, 0, 0, 12, 9, 12, 9);
			}
			if (Displaypropulsion2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("ices_mod:textures/screens/jump1.png"), w / 2 + -12, h / 2 + 14, 0, 0, 26, 9, 26, 9);
			}
			if (Displaypropulsion3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("ices_mod:textures/screens/jump2.png"), w / 2 + -19, h / 2 + 14, 0, 0, 40, 9, 40, 9);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
