package com.foonicular.amcm.util.enums;

import java.util.function.Supplier;

import com.foonicular.amcm.init.ItemInit;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum RubyItemTier implements IItemTier {

	/**
	 * The attack speeds start at 4, and the attack damage starts at 1. Order in
	 * which the numbers go int harvestLevel, int maxUses, float efficiency, float
	 * attackDamage, int enchantability, Supplier<Ingredient> repairMaterial
	 */
	RUBYTOOLS(2, 750, 5.0F, 0.0F, 15, () -> {
		return Ingredient.fromItems(ItemInit.RUBY.get());
	});

	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final LazyValue<Ingredient> repairMaterial;

	private RubyItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability,
			Supplier<Ingredient> repairMaterial) {
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