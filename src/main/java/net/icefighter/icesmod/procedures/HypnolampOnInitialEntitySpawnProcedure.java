package net.icefighter.icesmod.procedures;

import net.minecraftforge.eventbus.api.Event;

public class HypnolampOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = IcesModModEntities.DELETED_MOD_ELEMENT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				entityiterator.startRiding(entity);
			}
		}
		entity.getPersistentData().putDouble("posx", x);
		entity.getPersistentData().putDouble("posy", y);
		entity.getPersistentData().putDouble("posz", z);
	}
}
