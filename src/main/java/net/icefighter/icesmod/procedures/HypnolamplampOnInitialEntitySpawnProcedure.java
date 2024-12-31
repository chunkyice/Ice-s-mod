package net.icefighter.icesmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.particles.SimpleParticleType;

import net.icefighter.icesmod.init.IcesModModParticleTypes;
import net.icefighter.icesmod.IcesModMod;

public class HypnolamplampOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		while (true) {
			if (!entity.getPersistentData().getBoolean("yes")) {
				world.addParticle((SimpleParticleType) (IcesModModParticleTypes.HYPNOSPIRAL.get()), x, (y + 0.75), z, 0, 0, 0);
				entity.getPersistentData().putBoolean("yes", true);
				IcesModMod.queueServerWork(40, () -> {
					entity.getPersistentData().putBoolean("yes", false);
				});
			}
		}
	}
}
