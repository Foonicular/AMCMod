package com.foonicular.amcm.world.biomes;

import com.foonicular.amcm.init.BlockInit;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.SeaGrassConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;

public class MossyBiome extends Biome {
	
	private static final BlockState RUBY_ORE = BlockInit.RUBY_ORE.get().getDefaultState();
	
	public MossyBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		this.addStructure(Feature.SWAMP_HUT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
		this.addStructure(Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
		// For entities: 'entitytype, weight, minspawn, maxspawn
	    this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.BEE, 8, 4, 4));
	    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
	    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
	    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
	    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
	    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
	    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
	    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
	    DefaultBiomeFeatures.addCarvers(this);
	    DefaultBiomeFeatures.addStructures(this);
	    DefaultBiomeFeatures.addLakes(this);
	    DefaultBiomeFeatures.addMonsterRooms(this);
	    DefaultBiomeFeatures.addStoneVariants(this);
	    DefaultBiomeFeatures.addOres(this);
	    DefaultBiomeFeatures.addSwampClayDisks(this);
	    DefaultBiomeFeatures.addSwampVegetation(this);
	    DefaultBiomeFeatures.addMushrooms(this);
	    DefaultBiomeFeatures.addHugeMushrooms(this);
	    DefaultBiomeFeatures.addExtraReedsAndPumpkins(this);
	    DefaultBiomeFeatures.addSprings(this);
	    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEAGRASS.withConfiguration(new SeaGrassConfig(64, 0.6D)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	    DefaultBiomeFeatures.addFossils(this);
	    DefaultBiomeFeatures.addFreezeTopLayer(this);
	    this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RUBY_ORE, 4)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 0, 0, 32))));
	}
	
}
