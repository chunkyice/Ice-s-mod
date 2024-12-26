
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.icefighter.icesmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.icefighter.icesmod.world.inventory.SummonBookMenu;
import net.icefighter.icesmod.IcesModMod;

public class IcesModModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, IcesModMod.MODID);
	public static final RegistryObject<MenuType<SummonBookMenu>> SUMMON_BOOK = REGISTRY.register("summon_book", () -> IForgeMenuType.create(SummonBookMenu::new));
}
