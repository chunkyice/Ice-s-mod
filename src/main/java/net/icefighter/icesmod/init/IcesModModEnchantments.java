
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.icefighter.icesmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.icefighter.icesmod.enchantment.AirPropulsionEnchantment;
import net.icefighter.icesmod.IcesModMod;

public class IcesModModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, IcesModMod.MODID);
	public static final RegistryObject<Enchantment> AIR_PROPULSION = REGISTRY.register("air_propulsion", () -> new AirPropulsionEnchantment());
}
