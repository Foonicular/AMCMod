package com.foonicular.amcm.events;

import com.foonicular.amcm.AMCMod;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = AMCMod.MOD_ID, bus = Bus.FORGE)
public class JumpEvent {
	
	@SubscribeEvent
	public static void jumpEvent(LivingJumpEvent event) {
		LivingEntity livingEntity = event.getEntityLiving();
		livingEntity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 160, 1));
		livingEntity.addPotionEffect(new EffectInstance(Effects.STRENGTH, 160, 1));
	}
	
}
