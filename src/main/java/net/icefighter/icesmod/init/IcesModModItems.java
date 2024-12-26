
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.icefighter.icesmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.icefighter.icesmod.item.HeadsetItem;
import net.icefighter.icesmod.item.GoldenAppleBarrelItem;
import net.icefighter.icesmod.item.AmethystBookItem;
import net.icefighter.icesmod.IcesModMod;

public class IcesModModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, IcesModMod.MODID);
	public static final RegistryObject<Item> AMETHYST_BOOK = REGISTRY.register("amethyst_book", () -> new AmethystBookItem());
	public static final RegistryObject<Item> GOLDEN_APPLE_BARREL = REGISTRY.register("golden_apple_barrel", () -> new GoldenAppleBarrelItem());
	public static final RegistryObject<Item> BLUE_ORCHID_DISPLAY = block(IcesModModBlocks.BLUE_ORCHID_DISPLAY);
	public static final RegistryObject<Item> MIND_FUCK_BLOCK = block(IcesModModBlocks.MIND_FUCK_BLOCK);
	public static final RegistryObject<Item> HEADSET_HELMET = REGISTRY.register("headset_helmet", () -> new HeadsetItem.Helmet());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
