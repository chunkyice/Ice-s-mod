
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.icefighter.icesmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.icefighter.icesmod.IcesModMod;

public class IcesModModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, IcesModMod.MODID);
	public static final RegistryObject<SimpleParticleType> HYPNOSPIRAL = REGISTRY.register("hypnospiral", () -> new SimpleParticleType(true));
}
