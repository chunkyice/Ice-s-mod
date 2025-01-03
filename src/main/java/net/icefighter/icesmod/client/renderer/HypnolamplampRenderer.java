
package net.icefighter.icesmod.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SlimeModel;

import net.icefighter.icesmod.entity.HypnolamplampEntity;

public class HypnolamplampRenderer extends MobRenderer<HypnolamplampEntity, SlimeModel<HypnolamplampEntity>> {
	public HypnolamplampRenderer(EntityRendererProvider.Context context) {
		super(context, new SlimeModel(context.bakeLayer(ModelLayers.SLIME)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(HypnolamplampEntity entity) {
		return new ResourceLocation("ices_mod:textures/entities/hypnolamp.png");
	}

	@Override
	protected boolean isBodyVisible(HypnolamplampEntity entity) {
		return false;
	}
}
