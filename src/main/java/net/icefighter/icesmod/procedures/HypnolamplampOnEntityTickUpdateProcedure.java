package net.icefighter.icesmod.procedures;

import net.minecraftforge.eventbus.api.Event;

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
			world.addParticle((SimpleParticleType) (IcesModModParticleTypes.DELETED_MOD_ELEMENT.get()), x, (y + 0.75), z, 0, 0, 0);
			entity.getPersistentData().putDouble("ticks", 0);
		}
	}
}
