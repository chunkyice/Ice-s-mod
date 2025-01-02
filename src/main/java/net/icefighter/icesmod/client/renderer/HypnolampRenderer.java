
package net.icefighter.icesmod.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.icefighter.icesmod.entity.HypnolampEntity;
import net.icefighter.icesmod.client.model.Modelhypnolamp;

public class HypnolampRenderer extends MobRenderer<HypnolampEntity, Modelhypnolamp<HypnolampEntity>> {
	public HypnolampRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelhypnolamp(context.bakeLayer(Modelhypnolamp.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(HypnolampEntity entity) {
		return new ResourceLocation("ices_mod:textures/entities/hypnolamp.png");
	}
}
