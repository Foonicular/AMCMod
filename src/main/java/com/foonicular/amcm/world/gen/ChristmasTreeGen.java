package com.foonicular.amcm.world.gen;

import com.foonicular.amcm.world.AddModFeatures;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;

public class ChristmasTreeGen {
	
	public static void generateChristmasTree() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			AddModFeatures.addChristmasTrees(biome);
		}
	}
	
}
