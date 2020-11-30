package com.foonicular.amcm.world.biomes;

import com.foonicular.amcm.init.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;

public class MossyBiome extends Biome {

	private static final BlockState WATER = Blocks.WATER.getDefaultState();
	private static final BlockState COAL_ORE = Blocks.COAL_ORE.getDefaultState();
	private static final BlockState IRON_ORE = Blocks.IRON_ORE.getDefaultState();
	private static final BlockState GOLD_ORE = Blocks.GOLD_ORE.getDefaultState();
	private static final BlockState REDSTONE_ORE = Blocks.REDSTONE_ORE.getDefaultState();
	private static final BlockState DIAMOND_ORE = Blocks.DIAMOND_ORE.getDefaultState();
	private static final BlockState LAPIS_ORE = Blocks.LAPIS_ORE.getDefaultState();
	private static final BlockState RUBY_ORE = BlockInit.RUBY_ORE.get().getDefaultState();
	private static final BlockState DIRT = Blocks.DIRT.getDefaultState();
	private static final BlockState GRAVEL = Blocks.GRAVEL.getDefaultState();
	private static final BlockState GRANITE = Blocks.GRANITE.getDefaultState();
	private static final BlockState DIORITE = Blocks.DIORITE.getDefaultState();
	private static final BlockState ANDESITE = Blocks.ANDESITE.getDefaultState();
	private static final BlockState INFESTED_STONE = Blocks.INFESTED_STONE.getDefaultState();

	public MossyBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		// For entities: 'entitytype, weight, minspawn, maxspawn
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 15, 3, 6));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BEE, 12, 3, 7));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 3, 7));
		this.addCarver(GenerationStage.Carving.AIR,
				Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.14285715F)));
		this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CANYON, new ProbabilityConfig(0.02F)));
		this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS,
				Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(WATER))
						.withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(4))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE
						.withConfiguration(
								new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, COAL_ORE, 17))
						.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 128))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE
						.withConfiguration(
								new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, IRON_ORE, 9))
						.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 64))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE
						.withConfiguration(
								new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, GOLD_ORE, 9))
						.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(6, 0, 0, 32))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE
						.withConfiguration(
								new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, REDSTONE_ORE, 8))
						.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 16))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE
						.withConfiguration(
								new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, DIAMOND_ORE, 8))
						.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(12, 0, 0, 16))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE
						.withConfiguration(
								new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, LAPIS_ORE, 7))
						.withPlacement(Placement.COUNT_DEPTH_AVERAGE.configure(new DepthAverageConfig(1, 16, 16))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE
						.withConfiguration(
								new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RUBY_ORE, 9))
						.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 0, 0, 64))));
		this.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
				Feature.PILLAGER_OUTPOST.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
		this.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
				Feature.VILLAGE.withConfiguration(new VillageConfig("village/plains/town_centers", 6))
						.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE
						.withConfiguration(
								new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, DIRT, 33))
						.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 256))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE
						.withConfiguration(
								new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, GRAVEL, 33))
						.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 256))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE
						.withConfiguration(
								new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, GRANITE, 33))
						.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 80))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE
						.withConfiguration(
								new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, DIORITE, 33))
						.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 80))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE
						.withConfiguration(
								new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ANDESITE, 33))
						.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 80))));
		this.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
				Feature.SWAMP_HUT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES,
				Feature.MONSTER_ROOM.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.DUNGEONS.configure(new ChanceConfig(8))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.ORE
						.withConfiguration(
								new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, INFESTED_STONE, 9))
						.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(7, 0, 0, 64))));
		DefaultBiomeFeatures.addSwampVegetation(this);
		DefaultBiomeFeatures.addHugeMushrooms(this);
	}

}
