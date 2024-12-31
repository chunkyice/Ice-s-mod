package net.icefighter.icesmod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import java.util.ArrayList;

public class HypnolamplampOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double ticks = 0;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (x == entityiterator.level()
					.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(32)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entityiterator)).getBlockPos().getX()
					&& y == entityiterator.level()
							.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(32)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entityiterator)).getBlockPos()
							.getY()
					&& z == entityiterator.level()
							.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(32)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entityiterator)).getBlockPos()
							.getZ()) {
				entityiterator.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(x, y, z));
			}
		}
	}
}
