package com.foonicular.amcm.init;

import com.foonicular.amcm.AMCMod;
import com.foonicular.amcm.AMCMod.AMCModItemGroups;
import com.foonicular.amcm.objects.items.RingOfStrength;
import com.foonicular.amcm.util.enums.RubyArmorMaterial;
import com.foonicular.amcm.util.enums.RubyItemTier;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = AMCMod.MOD_ID, bus = Bus.MOD)
@ObjectHolder(AMCMod.MOD_ID)
public class ItemInit {

	// Items
	public static final Item ruby = null;
	public static final Item poison_apple = null;
	public static final Item ring_of_strength = null;

	// Tools
	public static final Item ruby_sword = null;
	public static final Item ruby_pickaxe = null;
	public static final Item ruby_axe = null;
	public static final Item ruby_shovel = null;
	public static final Item ruby_hoe = null;

	// Armor
	public static final Item ruby_helmet = null;
	public static final Item ruby_chestplate = null;
	public static final Item ruby_leggings = null;
	public static final Item ruby_boots = null;

	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register.Register<Item> event) {

		// Items
		event.getRegistry()
				.register(new Item(new Item.Properties().group(AMCModItemGroups.instance)).setRegistryName("ruby"));
		event.getRegistry().register(new RingOfStrength(new Item.Properties().group(AMCModItemGroups.instance))
				.setRegistryName("ring_of_strength"));

		// Foods
		event.getRegistry()
				.register(new Item(new Item.Properties().group(AMCModItemGroups.instance)
						.food(new Food.Builder().hunger(3).saturation(1.2f).setAlwaysEdible()
								.effect(new EffectInstance(Effects.BLINDNESS, 400, 1), 1.0f)
								.effect(new EffectInstance(Effects.HUNGER, 400, 1), 1.0f)
								.effect(new EffectInstance(Effects.WEAKNESS, 400, 1), 0.7f)
								.effect(new EffectInstance(Effects.NAUSEA, 400, 1), 0.5f).build()))
										.setRegistryName("poison_apple"));

		/**
		 * Tools Attack Damage (int), attack speed (float)
		 */
		event.getRegistry().register(
				new SwordItem(RubyItemTier.RUBYTOOLS, 4, -1.0f, new Item.Properties().group(AMCModItemGroups.instance))
						.setRegistryName("ruby_sword"));
		event.getRegistry().register(new PickaxeItem(RubyItemTier.RUBYTOOLS, 2, -1.5f,
				new Item.Properties().group(AMCModItemGroups.instance)).setRegistryName("ruby_pickaxe"));
		event.getRegistry().register(
				new AxeItem(RubyItemTier.RUBYTOOLS, 6, -2.5f, new Item.Properties().group(AMCModItemGroups.instance))
						.setRegistryName("ruby_axe"));
		event.getRegistry().register(
				new ShovelItem(RubyItemTier.RUBYTOOLS, 1, 0.0f, new Item.Properties().group(AMCModItemGroups.instance))
						.setRegistryName("ruby_shovel"));
		event.getRegistry().register(
				new HoeItem(RubyItemTier.RUBYTOOLS, 0.5f, new Item.Properties().group(AMCModItemGroups.instance))
						.setRegistryName("ruby_hoe"));

		// Armor
		event.getRegistry().register(new ArmorItem(RubyArmorMaterial.RUBYARMOR, EquipmentSlotType.HEAD,
				new Item.Properties().group(AMCModItemGroups.instance)).setRegistryName("ruby_helmet"));
		event.getRegistry().register(new ArmorItem(RubyArmorMaterial.RUBYARMOR, EquipmentSlotType.CHEST,
				new Item.Properties().group(AMCModItemGroups.instance)).setRegistryName("ruby_chestplate"));
		event.getRegistry().register(new ArmorItem(RubyArmorMaterial.RUBYARMOR, EquipmentSlotType.LEGS,
				new Item.Properties().group(AMCModItemGroups.instance)).setRegistryName("ruby_leggings"));
		event.getRegistry().register(new ArmorItem(RubyArmorMaterial.RUBYARMOR, EquipmentSlotType.FEET,
				new Item.Properties().group(AMCModItemGroups.instance)).setRegistryName("ruby_boots"));
	}

}
