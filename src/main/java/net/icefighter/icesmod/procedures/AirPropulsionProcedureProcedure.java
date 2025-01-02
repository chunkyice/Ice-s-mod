package net.icefighter.icesmod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.icefighter.icesmod.init.IcesModModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AirPropulsionProcedureProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.onGround()) {
			entity.getPersistentData().putDouble("AirPropulsion", ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getEnchantmentLevel(IcesModModEnchantments.AIR_PROPULSION.get())));
		}
		if (!(EnchantmentHelper.getItemEnchantmentLevel(IcesModModEnchantments.AIR_PROPULSION.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)) != 0)) {
			entity.getPersistentData().putDouble("AirPropulsion", 0);
		}
		if (0 < entity.getPersistentData().getDouble("AirPropulsionCooldwon")) {
			entity.getPersistentData().putDouble("AirPropulsionCooldwon", (entity.getPersistentData().getDouble("AirPropulsionCooldwon") - 0.05));
		}
	}
}
