package com.foonicular.amcm.objects.blocks;

import com.foonicular.amcm.init.ModTileEntityTypes;

import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

public class BlockQuarry extends OreBlock {

	public BlockQuarry(Properties properties) {
		super(properties);
	}
	
	@Override
	public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
		return 10;
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return ModTileEntityTypes.QUARRY.get().create();
	}
	
}
