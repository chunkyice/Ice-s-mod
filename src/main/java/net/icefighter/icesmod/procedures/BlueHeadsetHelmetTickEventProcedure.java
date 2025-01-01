package net.icefighter.icesmod.procedures;

import net.minecraftforge.eventbus.api.Event;

public class BlueHeadsetHelmetTickEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (Math.random() <= 0.02) {
			world.addParticle(ParticleTypes.NOTE, x, (y + 1.75), z, 0, 1, 0);
		}
		if (!entity.getPersistentData().getBoolean("playing1")) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"execute as @p at @s run stopsound @s record ices_mod:track2.song1");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"execute as @p at @s run stopsound @s record ices_mod:track2.song2");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"execute as @p at @s run stopsound @s record ices_mod:track2.song3");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"execute as @p at @s run stopsound @s record ices_mod:track2.song4");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"execute as @p at @s run stopsound @s record ices_mod:track2.song5");
			itemstack.getOrCreateTag().putDouble("song", (itemstack.getOrCreateTag().getDouble("song") + 1));
			if (itemstack.getOrCreateTag().getDouble("song") == 5) {
				itemstack.getOrCreateTag().putDouble("song", 0);
				entity.getPersistentData().putBoolean("playing1", false);
			}
			if (itemstack.getOrCreateTag().getDouble("song") == 0) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"execute as @p at @s run playsound ices_mod:track2.song1 record @s ~ ~ ~ 1 1 1");
				entity.getPersistentData().putBoolean("playing1", true);
				IcesModMod.queueServerWork(3040, () -> {
					entity.getPersistentData().putBoolean("playing1", false);
				});
			}
			if (itemstack.getOrCreateTag().getDouble("song") == 1) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"execute as @p at @s run playsound ices_mod:track2.song2 record @s ~ ~ ~ 1 1 1");
				entity.getPersistentData().putBoolean("playing1", true);
				IcesModMod.queueServerWork(3080, () -> {
					entity.getPersistentData().putBoolean("playing1", false);
				});
			}
			if (itemstack.getOrCreateTag().getDouble("song") == 2) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"execute as @p at @s run playsound ices_mod:track2.song3 record @s ~ ~ ~ 1 1 1");
				entity.getPersistentData().putBoolean("playing1", true);
				IcesModMod.queueServerWork(2900, () -> {
					entity.getPersistentData().putBoolean("playing1", false);
				});
			}
			if (itemstack.getOrCreateTag().getDouble("song") == 3) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"execute as @p at @s run playsound ices_mod:track2.song4 record @s ~ ~ ~ 1 1 1");
				entity.getPersistentData().putBoolean("playing1", true);
				IcesModMod.queueServerWork(2740, () -> {
					entity.getPersistentData().putBoolean("playing1", false);
				});
			}
			if (itemstack.getOrCreateTag().getDouble("song") == 4) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"execute as @p at @s run playsound ices_mod:track2.song5 record @s ~ ~ ~ 1 1 1");
				entity.getPersistentData().putBoolean("playing1", true);
				IcesModMod.queueServerWork(3180, () -> {
					entity.getPersistentData().putBoolean("playing1", false);
				});
			}
		}
	}
}
