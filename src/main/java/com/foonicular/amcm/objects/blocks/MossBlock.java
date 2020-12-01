package com.foonicular.amcm.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class MossBlock extends Block {

	public MossBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	   public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, net.minecraftforge.common.IPlantable plantable) {
	       net.minecraftforge.common.PlantType type = plantable.getPlantType(world, pos.offset(facing));

	       switch (type) {
	           case Desert: return false;
	           case Nether: return false;
	           case Crop:   return false;
	           case Cave:   return false;
	           case Plains: return true;
	           case Water:  return false;
	           case Beach:
	               boolean isBeach = this.getBlock() == Blocks.GRASS_BLOCK || net.minecraftforge.common.Tags.Blocks.DIRT.contains(this) || this.getBlock() == Blocks.SAND;
	               boolean hasWater = (world.getBlockState(pos.east()).getMaterial() == Material.WATER ||
	                       world.getBlockState(pos.west()).getMaterial() == Material.WATER ||
	                       world.getBlockState(pos.north()).getMaterial() == Material.WATER ||
	                       world.getBlockState(pos.south()).getMaterial() == Material.WATER);
	               return isBeach && hasWater;
	       }
	       return false;
	   }
	
}
