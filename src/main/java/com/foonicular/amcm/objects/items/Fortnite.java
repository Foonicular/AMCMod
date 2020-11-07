package com.foonicular.amcm.objects.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Fortnite extends Item {

	public Fortnite(Properties properties) {
		super(properties);
	}
	
	@Override
	public int getBurnTime(ItemStack itemStack) {
		return 600;
	}
	
}
