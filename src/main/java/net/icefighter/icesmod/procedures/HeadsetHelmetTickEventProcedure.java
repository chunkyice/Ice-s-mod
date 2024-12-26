package net.icefighter.icesmod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.icefighter.icesmod.IcesModMod;

public class HeadsetHelmetTickEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!(itemstack.getItem() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem())) {
			itemstack.getOrCreateTag().putBoolean("playing", false);
		}
		if (itemstack.getOrCreateTag().getDouble("Track") == 0) {
			if (!itemstack.getOrCreateTag().getBoolean("playing")) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"execute as @p at @s run stopsound @s record ices_mod:cafedeparis");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"execute as @p at @s run stopsound @s record ices_mod:coffeestop");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"execute as @p at @s run stopsound @s record ices_mod:distance");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"execute as @p at @s run stopsound @s record ices_mod:itashiba");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"execute as @p at @s run stopsound @s record ices_mod:riverbanks");
				itemstack.getOrCreateTag().putDouble("song", (itemstack.getOrCreateTag().getDouble("song") + 1));
				if (itemstack.getOrCreateTag().getDouble("song") == 5) {
					itemstack.getOrCreateTag().putDouble("song", 0);
					itemstack.getOrCreateTag().putBoolean("playing", true);
				}
				if (itemstack.getOrCreateTag().getDouble("song") == 0) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"execute as @p at @s run playsound ices_mod:coffeestop record @s ~ ~ ~ 1 1 1");
					itemstack.getOrCreateTag().putBoolean("playing", true);
					IcesModMod.queueServerWork(2780, () -> {
						itemstack.getOrCreateTag().putBoolean("playing", false);
					});
				}
				if (itemstack.getOrCreateTag().getDouble("song") == 1) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"execute as @p at @s run playsound ices_mod:riverbanks record @s ~ ~ ~ 1 1 1");
					itemstack.getOrCreateTag().putBoolean("playing", true);
					IcesModMod.queueServerWork(3340, () -> {
						itemstack.getOrCreateTag().putBoolean("playing", false);
					});
				}
				if (itemstack.getOrCreateTag().getDouble("song") == 2) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"execute as @p at @s run playsound ices_mod:distance record @s ~ ~ ~ 1 1 1");
					itemstack.getOrCreateTag().putBoolean("playing", true);
					IcesModMod.queueServerWork(3500, () -> {
						itemstack.getOrCreateTag().putBoolean("playing", false);
					});
				}
				if (itemstack.getOrCreateTag().getDouble("song") == 3) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"execute as @p at @s run playsound ices_mod:itabashi record @s ~ ~ ~ 1 1 1");
					itemstack.getOrCreateTag().putBoolean("playing", true);
					IcesModMod.queueServerWork(3640, () -> {
						itemstack.getOrCreateTag().putBoolean("playing", false);
					});
				}
				if (itemstack.getOrCreateTag().getDouble("song") == 4) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"execute as @p at @s run playsound ices_mod:cafedeparis record @s ~ ~ ~ 1 1 1");
					itemstack.getOrCreateTag().putBoolean("playing", true);
					IcesModMod.queueServerWork(2500, () -> {
						itemstack.getOrCreateTag().putBoolean("playing", false);
					});
				}
			}
		}
	}
}
