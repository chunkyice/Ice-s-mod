package net.icefighter.icesmod.procedures;

import net.minecraftforge.eventbus.api.Event;

@Mod.EventBusSubscriber
public class Displaypropulsion3Procedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static boolean execute(Entity entity) {
		return execute(null, entity);
	}

	private static boolean execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return false;
		if (entity.onGround() || entity.getPersistentData().getDouble("AirPropulsion") != 3 || entity instanceof LivingEntity _livEnt2 && _livEnt2.isFallFlying()) {
			return false;
		}
		return true;
	}
}
