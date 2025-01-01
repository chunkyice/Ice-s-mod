
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.icefighter.icesmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.icefighter.icesmod.entity.HypnolamplampEntity;
import net.icefighter.icesmod.entity.HypnolampEntity;
import net.icefighter.icesmod.IcesModMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class IcesModModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, IcesModMod.MODID);
	public static final RegistryObject<EntityType<HypnolampEntity>> HYPNOLAMP = register("hypnolamp", EntityType.Builder.<HypnolampEntity>of(HypnolampEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(HypnolampEntity::new).fireImmune().sized(0.4375f, 3f));
	public static final RegistryObject<EntityType<HypnolamplampEntity>> HYPNOLAMPLAMP = register("hypnolamplamp",
			EntityType.Builder.<HypnolamplampEntity>of(HypnolamplampEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HypnolamplampEntity::new)

					.sized(0.5f, 1f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			HypnolampEntity.init();
			HypnolamplampEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(HYPNOLAMP.get(), HypnolampEntity.createAttributes().build());
		event.put(HYPNOLAMPLAMP.get(), HypnolamplampEntity.createAttributes().build());
	}
}
