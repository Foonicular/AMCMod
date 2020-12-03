package com.foonicular.amcm.init;

import com.foonicular.amcm.AMCMod;
import com.foonicular.amcm.world.biomes.MossyBiome;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {

	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, AMCMod.MOD_ID);

	public static final RegistryObject<Biome> MOSSY_BIOME = BIOMES.register("mossy_biome",
			() -> new MossyBiome(new Biome.Builder().precipitation(Biome.RainType.RAIN).scale(0.1F).depth(-0.2F)
					.temperature(0.8F).waterColor(3044665).waterFogColor(3031609)
					.surfaceBuilder(SurfaceBuilder.SWAMP,
							new SurfaceBuilderConfig(BlockInit.MOSS_BLOCK.get().getDefaultState(),
									Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState()))
					.category(Category.SWAMP).downfall(0.9f).parent(null)));
	
	public static void registerBiomes() {
		registerBiome(MOSSY_BIOME.get(), Type.OVERWORLD, Type.SWAMP, Type.WET, Type.LUSH);
	}
	
	private static void registerBiome(Biome biome, Type... types) {
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 100));
	}
	
}
