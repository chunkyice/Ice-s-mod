
package net.icefighter.icesmod.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class BlueOrchidDisplayBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public BlueOrchidDisplayBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).instabreak().noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(0, 0, 0, 16, 7, 8), box(0, 7, 7, 16, 8, 8), box(0, 7, 0, 16, 8, 1), box(15, 7, 1, 16, 8, 7), box(0, 7, 1, 1, 8, 7), box(12.5, 7, 4.5, 14.5, 9, 6.5), box(7.5, 7, 1.75, 9.5, 9, 3.75),
					box(1.5, 7, 2.75, 3.5, 9, 4.75), box(0, 4, 8, 5, 5, 9), box(11, 4, 8, 16, 5, 9), box(5, 3, 8, 11, 4, 9));
			case NORTH -> Shapes.or(box(0, 0, 8, 16, 7, 16), box(0, 7, 8, 16, 8, 9), box(0, 7, 15, 16, 8, 16), box(0, 7, 9, 1, 8, 15), box(15, 7, 9, 16, 8, 15), box(1.5, 7, 9.5, 3.5, 9, 11.5), box(6.5, 7, 12.25, 8.5, 9, 14.25),
					box(12.5, 7, 11.25, 14.5, 9, 13.25), box(11, 4, 7, 16, 5, 8), box(0, 4, 7, 5, 5, 8), box(5, 3, 7, 11, 4, 8));
			case EAST -> Shapes.or(box(0, 0, 0, 8, 7, 16), box(7, 7, 0, 8, 8, 16), box(0, 7, 0, 1, 8, 16), box(1, 7, 0, 7, 8, 1), box(1, 7, 15, 7, 8, 16), box(4.5, 7, 1.5, 6.5, 9, 3.5), box(1.75, 7, 6.5, 3.75, 9, 8.5),
					box(2.75, 7, 12.5, 4.75, 9, 14.5), box(8, 4, 11, 9, 5, 16), box(8, 4, 0, 9, 5, 5), box(8, 3, 5, 9, 4, 11));
			case WEST -> Shapes.or(box(8, 0, 0, 16, 7, 16), box(8, 7, 0, 9, 8, 16), box(15, 7, 0, 16, 8, 16), box(9, 7, 15, 15, 8, 16), box(9, 7, 0, 15, 8, 1), box(9.5, 7, 12.5, 11.5, 9, 14.5), box(12.25, 7, 7.5, 14.25, 9, 9.5),
					box(11.25, 7, 1.5, 13.25, 9, 3.5), box(7, 4, 0, 8, 5, 5), box(7, 4, 11, 8, 5, 16), box(7, 3, 5, 8, 4, 11));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}
}
