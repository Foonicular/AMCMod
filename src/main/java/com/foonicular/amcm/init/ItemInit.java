package com.foonicular.amcm.init;

import java.util.function.Supplier;

import com.foonicular.amcm.AMCMod;
import com.foonicular.amcm.AMCMod.AMCModItemGroups;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
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
	
	// Tools
	public static final Item ruby_sword = null;
	public static final Item ruby_pickaxe = null;
	public static final Item ruby_axe = null;
	public static final Item ruby_shovel = null;
	public static final Item ruby_hoe = null;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register.Register<Item> event) {
		
		// Items
		event.getRegistry().register(new Item(new Item.Properties().group(AMCModItemGroups.instance)).setRegistryName("ruby"));
		
		// Foods
		event.getRegistry().register(new Item(new Item.Properties().group(AMCModItemGroups.instance)
				.food(new Food.Builder()
				.hunger(3)
				.saturation(1.2f)
				.setAlwaysEdible()
				.effect(new EffectInstance(Effects.BLINDNESS, 400, 1), 1.0f)
				.effect(new EffectInstance(Effects.HUNGER, 400, 1), 1.0f)
				.effect(new EffectInstance(Effects.WEAKNESS, 400, 1), 0.7f)
				.effect(new EffectInstance(Effects.NAUSEA, 400, 1), 0.5f)
				.build()))
				.setRegistryName("poison_apple"));
		
		/**
		 * Tools
		 * Attack Damage (int), attack speed (float)
		 */
		event.getRegistry().register(new SwordItem(ModItemTier.RUBYTOOLS, 4, -1.0f, new Item.Properties().group(AMCModItemGroups.instance)).setRegistryName("ruby_sword"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.RUBYTOOLS, 2, -1.5f, new Item.Properties().group(AMCModItemGroups.instance)).setRegistryName("ruby_pickaxe"));
		event.getRegistry().register(new AxeItem(ModItemTier.RUBYTOOLS, 6, -2.5f, new Item.Properties().group(AMCModItemGroups.instance)).setRegistryName("ruby_axe"));
		event.getRegistry().register(new ShovelItem(ModItemTier.RUBYTOOLS, 1, 0.0f, new Item.Properties().group(AMCModItemGroups.instance)).setRegistryName("ruby_shovel"));
		event.getRegistry().register(new HoeItem(ModItemTier.RUBYTOOLS, 0.5f, new Item.Properties().group(AMCModItemGroups.instance)).setRegistryName("ruby_hoe"));
	}
	
	
	
	public enum ModItemTier implements IItemTier {
		
		/**
		 * The attack speeds start at 4, and the attack damage starts at 1.
		 * Order in which the numbers go
		 * int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial
		 */
		RUBYTOOLS(2, 750, 5.0F, 0.0F, 15, () -> {
			return Ingredient.fromItems(ItemInit.ruby);
		});
		
		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantability;
		private final LazyValue<Ingredient> repairMaterial;
		
		private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = attackDamage;
			this.enchantability = enchantability;
			this.repairMaterial = new LazyValue<>(repairMaterial);
		}
		
		@Override
		public int getMaxUses() {
			return this.maxUses;
		}
		
		@Override
		public float getEfficiency() {
			return this.efficiency;
		}
		
		@Override
		public float getAttackDamage() {
			return this.attackDamage;
		}
		
		@Override
		public int getHarvestLevel() {
			return this.harvestLevel;
		}
		
		@Override
		public int getEnchantability() {
			return this.enchantability;
		}
		
		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}
		
	}
	
}
