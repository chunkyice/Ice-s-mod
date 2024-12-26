
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.icefighter.icesmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.icefighter.icesmod.block.MindFuckBlockBlock;
import net.icefighter.icesmod.block.BlueOrchidDisplayBlock;
import net.icefighter.icesmod.IcesModMod;

public class IcesModModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, IcesModMod.MODID);
	public static final RegistryObject<Block> BLUE_ORCHID_DISPLAY = REGISTRY.register("blue_orchid_display", () -> new BlueOrchidDisplayBlock());
	public static final RegistryObject<Block> MIND_FUCK_BLOCK = REGISTRY.register("mind_fuck_block", () -> new MindFuckBlockBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
