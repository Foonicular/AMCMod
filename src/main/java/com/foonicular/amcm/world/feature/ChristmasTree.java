package com.foonicular.amcm.world.feature;

import java.util.Random;

import com.foonicular.amcm.init.BlockInit;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class ChristmasTree extends Tree {

	public static final TreeFeatureConfig CHRISTMAS_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInit.CHRISTMAS_TREE_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(BlockInit.CHRISTMAS_TREE_LEAVES.get().getDefaultState()),
			new SpruceFoliagePlacer(2, 1))).baseHeight(6).heightRandA(3).trunkHeight(1).trunkHeightRandom(1)
					.trunkTopOffsetRandom(2).ignoreVines()
					.setSapling((IPlantable) BlockInit.CHRISTMAS_TREE_SAPLING.get()).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(CHRISTMAS_TREE_CONFIG);
	}

}
