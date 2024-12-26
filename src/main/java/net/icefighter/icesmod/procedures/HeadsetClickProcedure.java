package net.icefighter.icesmod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.icefighter.icesmod.init.IcesModModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HeadsetClickProcedure {
	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown() && (entity instanceof LivingEntity _entUseItem1 ? _entUseItem1.getUseItem() : ItemStack.EMPTY).getItem() == IcesModModItems.HEADSET_HELMET.get()) {
			(entity instanceof LivingEntity _entUseItem3 ? _entUseItem3.getUseItem() : ItemStack.EMPTY).getOrCreateTag().putBoolean("playing", false);
			(entity instanceof LivingEntity _entUseItem5 ? _entUseItem5.getUseItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("song", 0);
			(entity instanceof LivingEntity _entUseItem7 ? _entUseItem7.getUseItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("Track", 0);
		}
	}
}
