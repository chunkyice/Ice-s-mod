package net.icefighter.icesmod.procedures;

import net.minecraftforge.eventbus.api.Event;

public class AirPorpulsionJumpProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!entity.onGround() && !(entity instanceof LivingEntity _livEnt1 && _livEnt1.isFallFlying()) && entity.getPersistentData().getDouble("AirPropulsion") > 0 && entity.getPersistentData().getDouble("AirPropulsionCooldwon") <= 0) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() * 1.25), 1, (entity.getDeltaMovement().z() * 1.25)));
			entity.getPersistentData().putDouble("AirPropulsion", (entity.getPersistentData().getDouble("AirPropulsion") - 1));
			entity.getPersistentData().putDouble("AirPropulsionCooldwon", 0.75);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.flap")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.flap")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"particle poof ~ ~ ~ 1 0.5 1 0.25 20 normal");
		}
	}
}
