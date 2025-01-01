
package net.icefighter.icesmod.client.renderer;

public class HypnolampRenderer extends MobRenderer<HypnolampEntity, Modelhypnolamp<HypnolampEntity>> {

	public HypnolampRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelhypnolamp(context.bakeLayer(Modelhypnolamp.LAYER_LOCATION)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(HypnolampEntity entity) {
		return new ResourceLocation("ices_mod:textures/entities/hypnolamp.png");
	}

}
