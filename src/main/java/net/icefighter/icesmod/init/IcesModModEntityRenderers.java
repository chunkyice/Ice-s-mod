
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.icefighter.icesmod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.icefighter.icesmod.client.renderer.HypnolamplampRenderer;
import net.icefighter.icesmod.client.renderer.HypnolampRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class IcesModModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(IcesModModEntities.HYPNOLAMP.get(), HypnolampRenderer::new);
		event.registerEntityRenderer(IcesModModEntities.HYPNOLAMPLAMP.get(), HypnolamplampRenderer::new);
	}
}
