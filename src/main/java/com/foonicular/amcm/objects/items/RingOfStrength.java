package com.foonicular.amcm.objects.items;

import java.util.List;

import com.foonicular.amcm.util.helpers.KeyboardHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class RingOfStrength extends Item {

	public RingOfStrength(Properties properties) {
		super(properties);
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if (KeyboardHelper.isHoldingShift() & KeyboardHelper.isHoldingR()) {
			tooltip.add(new StringTextComponent("The Ring Of Strength is an artifact of true craftmanship. You must be a true craftsman to create one of these."));
			tooltip.add(new StringTextComponent("\u00A76" + "Right click while holding me to gain my effects."));
		} else {
			tooltip.add(new StringTextComponent("Hold" + "\u00A7e" + " SHIFT " + "& " + "\u00A7e" + "R " + "\u00A77" + "for more information."));
		}
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 200, 2));
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	@Override
	public Rarity getRarity(ItemStack stack) {
		return Rarity.RARE;
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack) {
		return 1;
	}
	
}
