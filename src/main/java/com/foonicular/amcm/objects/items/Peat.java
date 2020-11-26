package com.foonicular.amcm.objects.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Peat extends Item {

	public Peat(Properties properties) {
		super(properties);
	}
	
	@Override
	public int getBurnTime(ItemStack itemStack) {
		return 1600;
	}
	
}
