package com.foonicular.amcm.init;

import com.foonicular.amcm.AMCMod;
import com.foonicular.amcm.objects.blocks.BlockQuarry;
import com.foonicular.amcm.objects.blocks.MossBlock;
import com.foonicular.amcm.objects.blocks.Oven;
import com.foonicular.amcm.objects.blocks.RubyButton;
import com.foonicular.amcm.objects.blocks.RubyOre;
import com.foonicular.amcm.objects.blocks.RubyPressurePlate;

import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

	public static DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, AMCMod.MOD_ID);

	// Blocks
	public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.0f, 6.0f)
					.sound(SoundType.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE)));
	public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", () -> new RubyOre());
	public static final RegistryObject<Block> OVEN = BLOCKS.register("oven",
			() -> new Oven(Block.Properties.create(Material.ANVIL).hardnessAndResistance(2.0f, 7.0f).harvestLevel(2)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.ANVIL).lightValue(1)));
	public static final RegistryObject<Block> QUARRY = BLOCKS.register("quarry",
			() -> new BlockQuarry(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 9.0f)
					.harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL).lightValue(1)));
	public static final RegistryObject<Block> MOSS_BLOCK = BLOCKS.register("moss_block",
			() -> new MossBlock(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.5f, 0.5f)
					.harvestTool(ToolType.SHOVEL).sound(SoundType.WET_GRASS)));
	public static final RegistryObject<Block> POOP_BLOCK = BLOCKS.register("poop_block",
			() -> new Block(Block.Properties.create(Material.CLAY).hardnessAndResistance(2.0f, 0.5f)
					.harvestTool(ToolType.SHOVEL).sound(SoundType.WET_GRASS)));

	// Stairs
	public static final RegistryObject<Block> RUBY_STAIRS = BLOCKS.register("ruby_stairs",
			() -> new StairsBlock(() -> BlockInit.RUBY_BLOCK.get().getDefaultState(),
					Block.Properties.create(Material.IRON).hardnessAndResistance(1.0f, 6.0f).sound(SoundType.METAL)
							.harvestLevel(2).harvestTool(ToolType.PICKAXE)));

	// Fences
	public static final RegistryObject<Block> RUBY_FENCE = BLOCKS.register("ruby_fence",
			() -> new FenceBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(1.0f, 6.0f)
					.sound(SoundType.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE)));

	// Buttons
	public static final RegistryObject<Block> RUBY_BUTTON = BLOCKS.register("ruby_button",
			() -> new RubyButton(Block.Properties.create(Material.IRON).hardnessAndResistance(1.0f, 6.0f)
					.sound(SoundType.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE)));

	// Pressure Plates
	public static final RegistryObject<Block> RUBY_PRESSURE_PLATE = BLOCKS.register("ruby_pressure_plate",
			() -> new RubyPressurePlate(Sensitivity.MOBS,
					Block.Properties.create(Material.IRON).hardnessAndResistance(1.0f, 6.0f).sound(SoundType.METAL)
							.harvestLevel(2).harvestTool(ToolType.PICKAXE)));

}
