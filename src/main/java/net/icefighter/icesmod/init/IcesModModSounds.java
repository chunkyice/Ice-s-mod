
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.icefighter.icesmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.icefighter.icesmod.IcesModMod;

public class IcesModModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, IcesModMod.MODID);
	public static final RegistryObject<SoundEvent> COFFEESTOP = REGISTRY.register("coffeestop", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("ices_mod", "coffeestop")));
	public static final RegistryObject<SoundEvent> RIVERBANKS = REGISTRY.register("riverbanks", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("ices_mod", "riverbanks")));
	public static final RegistryObject<SoundEvent> DISTANCE = REGISTRY.register("distance", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("ices_mod", "distance")));
	public static final RegistryObject<SoundEvent> ITASHIBA = REGISTRY.register("itashiba", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("ices_mod", "itashiba")));
	public static final RegistryObject<SoundEvent> CAFEDEPARIS = REGISTRY.register("cafedeparis", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("ices_mod", "cafedeparis")));
	public static final RegistryObject<SoundEvent> RADIO = REGISTRY.register("radio", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("ices_mod", "radio")));
	public static final RegistryObject<SoundEvent> ITEM_MAGNET_USE = REGISTRY.register("item.magnet.use", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("ices_mod", "item.magnet.use")));
}
