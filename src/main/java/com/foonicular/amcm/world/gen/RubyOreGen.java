package com.foonicular.amcm.world.gen;

import com.foonicular.amcm.init.BlockInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class RubyOreGen {

	public static void generateOre() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			// The numbers are RARITY, BOTTOM OFFSET, TOP OFFSET, and MAXIMUM. (Maximum is added to top offset.)
			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 0, 0, 64));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
							BlockInit.RUBY_ORE.get().getDefaultState(), 6)).withPlacement(customConfig));
		}
	}
}
