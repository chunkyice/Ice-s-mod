
package net.icefighter.icesmod.item;

public class MagnetItem extends Item {
	public MagnetItem() {
		super(new Item.Properties().durability(256).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.BOW;
	}

	@Override
	public int getEnchantmentValue() {
		return 1;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 2000;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		entity.startUsingItem(hand);
		MagnetRightclickedProcedure.execute(world, entity);
		return ar;
	}
}