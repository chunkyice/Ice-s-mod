package net.icefighter.icesmod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.icefighter.icesmod.init.IcesModModParticleTypes;

import java.util.List;
import java.util.Comparator;

public class HypnolamplampOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Player) {
					entityiterator.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(x, (y + 0.75), z));
				}
			}
		}
		entity.getPersistentData().putDouble("ticks", (entity.getPersistentData().getDouble("ticks") + 1));
		if (entity.getPersistentData().getDouble("ticks") == 40) {
			world.addParticle((SimpleParticleType) (IcesModModParticleTypes.HYPNOSPIRAL.get()), x, (y + 0.75), z, 0, 0, 0);
			entity.getPersistentData().putDouble("ticks", 0);
		}
	}
}
