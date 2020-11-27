package com.foonicular.amcm.init;

import com.foonicular.amcm.AMCMod;
import com.foonicular.amcm.objects.blocks.BlockQuarry;
import com.foonicular.amcm.objects.blocks.Oven;
import com.foonicular.amcm.objects.blocks.RubyOre;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

	public static DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, AMCMod.MOD_ID);

	public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.0f, 6.0f)
					.sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", () -> new RubyOre());
	public static final RegistryObject<Block> OVEN = BLOCKS.register("oven",
			() -> new Oven(Block.Properties.create(Material.ANVIL).hardnessAndResistance(2.0f, 7.0f).harvestLevel(2)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.ANVIL).lightValue(1)));
	public static final RegistryObject<Block> QUARRY = BLOCKS.register("quarry",
			() -> new BlockQuarry(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 9.0f)
					.harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE).lightValue(1)));

}
