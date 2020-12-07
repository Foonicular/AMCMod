package com.foonicular.amcm.init;

import com.foonicular.amcm.AMCMod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {

	public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS,
			AMCMod.MOD_ID);

	public static final Lazy<SoundEvent> LAZY_PROMISES_MUSIC = Lazy.of(() -> new SoundEvent(new ResourceLocation(AMCMod.MOD_ID, "disc.promises")));

	public static final RegistryObject<SoundEvent> PROMISES_MUSIC = SOUNDS.register("promises_music",
			LAZY_PROMISES_MUSIC);

}
