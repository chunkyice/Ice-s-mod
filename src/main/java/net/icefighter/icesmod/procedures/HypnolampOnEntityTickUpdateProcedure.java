package net.icefighter.icesmod.procedures;

import net.minecraftforge.eventbus.api.Event;

public class HypnolampOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double amount = 0;
		boolean spawned = false;
		amount = 0;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof HypnolamplampEntity) {
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					amount = amount + 1;
				}
			}
		}
		if (amount == 0 && spawned) {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL)), 255);
		} else {
			if (spawned == false) {
				spawned = true;
			}
		}
	}
}
