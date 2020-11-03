package com.foonicular.amcm.init;

import com.foonicular.amcm.AMCMod;
import com.foonicular.amcm.AMCMod.AMCModItemGroups;
import com.foonicular.amcm.objects.blocks.Oven;
import com.foonicular.amcm.objects.blocks.RubyOre;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(AMCMod.MOD_ID)
@Mod.EventBusSubscriber(modid = AMCMod.MOD_ID, bus = Bus.MOD)
public class BlockInit {

	public static final Block ruby_block = null;
	public static final Block ruby_ore = null;
	public static final Block oven = null;

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry()
				.register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.0f, 6.0f)
						.sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE))
								.setRegistryName("ruby_block"));

		event.getRegistry()
				.register(new Oven(Block.Properties.create(Material.ANVIL).hardnessAndResistance(2.0f, 7.0f)
						.harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.ANVIL).lightValue(1))
								.setRegistryName("oven"));

		event.getRegistry().register(new RubyOre().setRegistryName("ruby_ore"));
	}

	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new BlockItem(ruby_block, new Item.Properties().group(AMCModItemGroups.instance))
				.setRegistryName("ruby_block"));

		event.getRegistry().register(new BlockItem(ruby_ore, new Item.Properties().group(AMCModItemGroups.instance))
				.setRegistryName("ruby_ore"));

		event.getRegistry().register(
				new BlockItem(oven, new Item.Properties().group(AMCModItemGroups.instance)).setRegistryName("oven"));
	}

}
