
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.icefighter.icesmod.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.icefighter.icesmod.network.AirPropulsionKeyMessage;
import net.icefighter.icesmod.IcesModMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class IcesModModKeyMappings {
	public static final KeyMapping AIR_PROPULSION_KEY = new KeyMapping("key.ices_mod.air_propulsion_key", GLFW.GLFW_KEY_SPACE, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				IcesModMod.PACKET_HANDLER.sendToServer(new AirPropulsionKeyMessage(0, 0));
				AirPropulsionKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(AIR_PROPULSION_KEY);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				AIR_PROPULSION_KEY.consumeClick();
			}
		}
	}
}
