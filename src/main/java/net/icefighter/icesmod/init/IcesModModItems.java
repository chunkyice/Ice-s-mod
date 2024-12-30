
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.icefighter.icesmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import net.icefighter.icesmod.item.PurpleHeadsetItem;
import net.icefighter.icesmod.item.MagnetItem;
import net.icefighter.icesmod.item.HeadsetItem;
import net.icefighter.icesmod.item.GoldenAppleBarrelItem;
import net.icefighter.icesmod.item.ChorusShieldItem;
import net.icefighter.icesmod.item.BlueheadsetItem;
import net.icefighter.icesmod.item.AmethystBookItem;
import net.icefighter.icesmod.IcesModMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class IcesModModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, IcesModMod.MODID);
	public static final RegistryObject<Item> AMETHYST_BOOK = REGISTRY.register("amethyst_book", () -> new AmethystBookItem());
	public static final RegistryObject<Item> GOLDEN_APPLE_BARREL = REGISTRY.register("golden_apple_barrel", () -> new GoldenAppleBarrelItem());
	public static final RegistryObject<Item> BLUE_ORCHID_DISPLAY = block(IcesModModBlocks.BLUE_ORCHID_DISPLAY);
	public static final RegistryObject<Item> MIND_FUCK_BLOCK = block(IcesModModBlocks.MIND_FUCK_BLOCK);
	public static final RegistryObject<Item> BLACK_HEADSET_HELMET = REGISTRY.register("black_headset_helmet", () -> new HeadsetItem.Helmet());
	public static final RegistryObject<Item> MAGNET = REGISTRY.register("magnet", () -> new MagnetItem());
	public static final RegistryObject<Item> BLUEHEADSET_HELMET = REGISTRY.register("blueheadset_helmet", () -> new BlueheadsetItem.Helmet());
	public static final RegistryObject<Item> PURPLE_HEADSET_HELMET = REGISTRY.register("purple_headset_helmet", () -> new PurpleHeadsetItem.Helmet());
	public static final RegistryObject<Item> CHORUS_SHIELD = REGISTRY.register("chorus_shield", () -> new ChorusShieldItem());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemProperties.register(CHORUS_SHIELD.get(), new ResourceLocation("blocking"), ItemProperties.getProperty(Items.SHIELD, new ResourceLocation("blocking")));
		});
	}
}
