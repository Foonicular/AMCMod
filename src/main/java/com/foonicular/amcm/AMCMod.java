package com.foonicular.amcm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.foonicular.amcm.init.BiomeInit;
import com.foonicular.amcm.init.BlockInit;
import com.foonicular.amcm.init.ItemInit;
import com.foonicular.amcm.init.ModTileEntityTypes;
import com.foonicular.amcm.init.SoundInit;
import com.foonicular.amcm.world.gen.RubyOreGen;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

@Mod("amcmod")
@Mod.EventBusSubscriber(modid = AMCMod.MOD_ID, bus = Bus.MOD)
public class AMCMod {
	
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "amcmod";
    
    public AMCMod() {
    	
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);
        
        SoundInit.SOUNDS.register(modEventBus);
        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
        BiomeInit.BIOMES.register(modEventBus);
        
        MinecraftForge.EVENT_BUS.register(this);
        
    }
    
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
    	final IForgeRegistry<Item> registry = event.getRegistry();
    	
    	BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().group(AMCMod.TAB);
    		final BlockItem blockItem = new BlockItem(block, properties);
    		blockItem.setRegistryName(block.getRegistryName());
    		registry.register(blockItem);
    	});
    	
    	LOGGER.debug("Registered Block Items!");
    	
    }
    
    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
    	BiomeInit.registerBiomes();
    }
    
    private void setup(final FMLCommonSetupEvent event) {
    	
    }
    
    private void doClientStuff(final FMLClientSetupEvent event) {
    	
    }
    
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        
    }
    
    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
    	RubyOreGen.generateOre();
    }
    
    // Custom Item Group
    public static final ItemGroup TAB = new ItemGroup("amcmodtab") {
        @Override
        public ItemStack createIcon() { return new ItemStack(ItemInit.RUBY.get()); }
    };
    
}
