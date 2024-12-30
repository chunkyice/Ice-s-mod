package net.icefighter.icesmod.procedures;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;

import net.icefighter.icesmod.init.IcesModModItems;
import net.icefighter.icesmod.IcesModMod;

import javax.annotation.Nullable;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(value = {Dist.CLIENT})
public class HeadsetClickProcedure {
	@SubscribeEvent
	public static void onLeftClick(PlayerInteractEvent.LeftClickEmpty event) {
		IcesModMod.PACKET_HANDLER.sendToServer(new HeadsetClickMessage());
		execute(event.getEntity());
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class HeadsetClickMessage {
		public HeadsetClickMessage() {
		}

		public HeadsetClickMessage(FriendlyByteBuf buffer) {
		}

		public static void buffer(HeadsetClickMessage message, FriendlyByteBuf buffer) {
		}

		public static void handler(HeadsetClickMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getSender().level().hasChunkAt(context.getSender().blockPosition()))
					return;
				execute(context.getSender());
			});
			context.setPacketHandled(true);
		}

		@SubscribeEvent
		public static void registerMessage(FMLCommonSetupEvent event) {
			IcesModMod.addNetworkMessage(HeadsetClickMessage.class, HeadsetClickMessage::buffer, HeadsetClickMessage::new, HeadsetClickMessage::handler);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown() && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == IcesModModItems.BLACK_HEADSET_HELMET.get()) {
			entity.getPersistentData().putBoolean("playing", false);
			(entity instanceof LivingEntity _entUseItem4 ? _entUseItem4.getUseItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("song", 0);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("headset fixed"), true);
		}
	}
}
