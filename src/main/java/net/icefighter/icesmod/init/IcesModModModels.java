
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.icefighter.icesmod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.icefighter.icesmod.client.model.Modelhypnolamp;
import net.icefighter.icesmod.client.model.Modelclown_nose;
import net.icefighter.icesmod.client.model.ModelCustomModel;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class IcesModModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelCustomModel.LAYER_LOCATION, ModelCustomModel::createBodyLayer);
		event.registerLayerDefinition(Modelclown_nose.LAYER_LOCATION, Modelclown_nose::createBodyLayer);
		event.registerLayerDefinition(Modelhypnolamp.LAYER_LOCATION, Modelhypnolamp::createBodyLayer);
	}
}
