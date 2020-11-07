package com.foonicular.amcm.init;

import com.foonicular.amcm.AMCMod;
import com.foonicular.amcm.objects.items.Fortnite;
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
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	
	public static DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, AMCMod.MOD_ID);
	
	// Items
	public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
			() -> new Item(new Item.Properties().group(AMCMod.TAB)));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> POISON_APPLE = ITEMS.register("poison_apple",
			() -> new Item(new Item.Properties().group(AMCMod.TAB)
					.food(new Food.Builder().hunger(3).saturation(1.2f).setAlwaysEdible()
							.effect(new EffectInstance(Effects.BLINDNESS, 400, 1), 1.0f)
							.effect(new EffectInstance(Effects.HUNGER, 400, 1), 1.0f)
							.effect(new EffectInstance(Effects.WEAKNESS, 400, 1), 0.7f)
							.effect(new EffectInstance(Effects.NAUSEA, 400, 1), 0.5f).build())));
	public static final RegistryObject<Item> RING_OF_STRENGTH = ITEMS.register("ring_of_strength",
			() -> new RingOfStrength(new Item.Properties().group(AMCMod.TAB)));
	
	/**
	 * Tools
	 * 
	 * Attack Damage (int), attack speed (float)
	 */
	public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
			() -> new SwordItem(RubyItemTier.RUBYTOOLS, 4, -1.0f, new Item.Properties().group(AMCMod.TAB)));
	public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
			() -> new PickaxeItem(RubyItemTier.RUBYTOOLS, 2, -1.5f, new Item.Properties().group(AMCMod.TAB)));
	public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe",
			() -> new AxeItem(RubyItemTier.RUBYTOOLS, 6, -2.5f, new Item.Properties().group(AMCMod.TAB)));
	public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
			() -> new ShovelItem(RubyItemTier.RUBYTOOLS, 1, 0.0f, new Item.Properties().group(AMCMod.TAB)));
	public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
			() -> new HoeItem(RubyItemTier.RUBYTOOLS, 0.5f, new Item.Properties().group(AMCMod.TAB)));
	
	// Armor
	public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet",
			() -> new ArmorItem(RubyArmorMaterial.RUBYARMOR, EquipmentSlotType.HEAD,
					new Item.Properties().group(AMCMod.TAB)));
	public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
			() -> new ArmorItem(RubyArmorMaterial.RUBYARMOR, EquipmentSlotType.CHEST,
					new Item.Properties().group(AMCMod.TAB)));
	public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
			() -> new ArmorItem(RubyArmorMaterial.RUBYARMOR, EquipmentSlotType.LEGS,
					new Item.Properties().group(AMCMod.TAB)));
	public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots",
			() -> new ArmorItem(RubyArmorMaterial.RUBYARMOR, EquipmentSlotType.FEET,
					new Item.Properties().group(AMCMod.TAB)));
	
	// Fuel
	public static final RegistryObject<Item> FORTNITE = ITEMS.register("fortnite",
			() -> new Fortnite(new Item.Properties().group(AMCMod.TAB)));
	
}
