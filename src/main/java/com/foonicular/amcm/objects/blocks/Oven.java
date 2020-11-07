package com.foonicular.amcm.objects.blocks;

import java.util.stream.Stream;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class Oven extends Block {
	
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	
	private static final VoxelShape SHAPE_N = Stream.of(
			Block.makeCuboidShape(1, 1, 1, 15, 7, 15),
			Block.makeCuboidShape(0, 0, 0, 1, 2, 1),
			Block.makeCuboidShape(0, 1, 1, 1, 2, 2),
			Block.makeCuboidShape(15, 0, 0, 16, 2, 1),
			Block.makeCuboidShape(15, 1, 1, 16, 2, 2),
			Block.makeCuboidShape(0, 0, 15, 1, 2, 16),
			Block.makeCuboidShape(0, 1, 14, 1, 2, 15),
			Block.makeCuboidShape(15, 0, 15, 16, 2, 16),
			Block.makeCuboidShape(15, 1, 14, 16, 2, 15),
			Block.makeCuboidShape(2, 8, 2, 14, 9, 14),
			Block.makeCuboidShape(0, 7, 0, 16, 8, 16),
			Block.makeCuboidShape(6, 8, 14, 10, 16, 15),
			Block.makeCuboidShape(6, 9, 11, 7, 16, 14),
			Block.makeCuboidShape(9, 7, 11, 10, 16, 14),
			Block.makeCuboidShape(7, 9, 11, 9, 16, 12)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	private static final VoxelShape SHAPE_W = Stream.of(
			Block.makeCuboidShape(1, 1, 1, 15, 7, 15),
			Block.makeCuboidShape(0, 0, 15, 1, 2, 16),
			Block.makeCuboidShape(1, 1, 15, 2, 2, 16),
			Block.makeCuboidShape(0, 0, 0, 1, 2, 1),
			Block.makeCuboidShape(1, 1, 0, 2, 2, 1),
			Block.makeCuboidShape(15, 0, 15, 16, 2, 16),
			Block.makeCuboidShape(14, 1, 15, 15, 2, 16),
			Block.makeCuboidShape(15, 0, 0, 16, 2, 1),
			Block.makeCuboidShape(14, 1, 0, 15, 2, 1),
			Block.makeCuboidShape(2, 8, 2, 14, 9, 14),
			Block.makeCuboidShape(0, 7, 0, 16, 8, 16),
			Block.makeCuboidShape(14, 8, 6, 15, 16, 10),
			Block.makeCuboidShape(11, 9, 9, 14, 16, 10),
			Block.makeCuboidShape(11, 7, 6, 14, 16, 7),
			Block.makeCuboidShape(11, 9, 7, 12, 16, 9)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	private static final VoxelShape SHAPE_S = Stream.of(
			Block.makeCuboidShape(1, 1, 1, 15, 7, 15),
			Block.makeCuboidShape(15, 0, 15, 16, 2, 16),
			Block.makeCuboidShape(15, 1, 14, 16, 2, 15),
			Block.makeCuboidShape(0, 0, 15, 1, 2, 16),
			Block.makeCuboidShape(0, 1, 14, 1, 2, 15),
			Block.makeCuboidShape(15, 0, 0, 16, 2, 1),
			Block.makeCuboidShape(15, 1, 1, 16, 2, 2),
			Block.makeCuboidShape(0, 0, 0, 1, 2, 1),
			Block.makeCuboidShape(0, 1, 1, 1, 2, 2),
			Block.makeCuboidShape(2, 8, 2, 14, 9, 14),
			Block.makeCuboidShape(0, 7, 0, 16, 8, 16),
			Block.makeCuboidShape(6, 8, 1, 10, 16, 2),
			Block.makeCuboidShape(9, 9, 2, 10, 16, 5),
			Block.makeCuboidShape(6, 7, 2, 7, 16, 5),
			Block.makeCuboidShape(7, 9, 4, 9, 16, 5)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	private static final VoxelShape SHAPE_E = Stream.of(
			Block.makeCuboidShape(1, 1, 1, 15, 7, 15),
			Block.makeCuboidShape(15, 0, 0, 16, 2, 1),
			Block.makeCuboidShape(14, 1, 0, 15, 2, 1),
			Block.makeCuboidShape(15, 0, 15, 16, 2, 16),
			Block.makeCuboidShape(14, 1, 15, 15, 2, 16),
			Block.makeCuboidShape(0, 0, 0, 1, 2, 1),
			Block.makeCuboidShape(1, 1, 0, 2, 2, 1),
			Block.makeCuboidShape(0, 0, 15, 1, 2, 16),
			Block.makeCuboidShape(1, 1, 15, 2, 2, 16),
			Block.makeCuboidShape(2, 8, 2, 14, 9, 14),
			Block.makeCuboidShape(0, 7, 0, 16, 8, 16),
			Block.makeCuboidShape(1, 8, 6, 2, 16, 10),
			Block.makeCuboidShape(2, 9, 6, 5, 16, 7),
			Block.makeCuboidShape(2, 7, 9, 5, 16, 10),
			Block.makeCuboidShape(4, 9, 7, 5, 16, 9)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	public Oven(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.get(FACING)) {
		case NORTH:
			return SHAPE_N;
		case SOUTH:
			return SHAPE_S;
		case EAST:
			return SHAPE_E;
		case WEST:
			return SHAPE_W;
		default:
			return SHAPE_N;
		}
	}
	
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}
	
	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}
	
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}
	
}
