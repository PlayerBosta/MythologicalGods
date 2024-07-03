package com.playerbosta.mythologyunleashed;

import com.playerbosta.mythologyunleashed.screen.GemPolishingStationScreen;
import com.mojang.logging.LogUtils;
import com.playerbosta.mythologyunleashed.block.ModBlocks;
import com.playerbosta.mythologyunleashed.block.entity.ModBlockEntities;
import com.playerbosta.mythologyunleashed.item.ModItems;
import com.playerbosta.mythologyunleashed.screen.ModMenuTypes;
import com.playerbosta.mythologyunleashed.sound.ModSounds;
import com.playerbosta.mythologyunleashed.registers.*;
import com.playerbosta.mythologyunleashed.config.Config;
import com.playerbosta.mythologyunleashed.config.ClientConfig;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;

import static com.playerbosta.mythologyunleashed.screen.ModMenuTypes.GEM_POLISHING_MENU;


@Mod(MythologyUnleashed.MODID)
public class MythologyUnleashed
{

    public static final String MODID = "mythologyunleashed";

   // public static final Logger LOGGER = LogManager.getLogger(MythologyUnleashed.MODID);

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));

    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties()));


    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEat().nutrition(1).saturationMod(2f).build())));

    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(EXAMPLE_ITEM.get());
            }).build());

    public MythologyUnleashed() {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        //PSTAttributes.REGISTRY.register(modEventBus);
        //PSTRecipeSerializers.REGISTRY.register(modEventBus);
        //PSTEffects.REGISTRY.register(modEventBus);
        PSTSkillBonuses.REGISTRY.register(modEventBus);
        //PSTLivingConditions.REGISTRY.register(modEventBus);
        //PSTLivingMultipliers.REGISTRY.register(modEventBus);
        //PSTDamageConditions.REGISTRY.register(modEventBus);
        //PSTItemBonuses.REGISTRY.register(modEventBus);
        //PSTItemConditions.REGISTRY.register(modEventBus);
        //PSTEnchantmentConditions.REGISTRY.register(modEventBus);
        //PSTLootPoolEntries.REGISTRY.register(modEventBus);
        //PSTGemBonuses.REGISTRY.register(modEventBus);
        PSTEventListeners.REGISTRY.register(modEventBus);
        //modEventBus.addListener(this::registerCurioSlots);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC);
        //addCompatibilities();


        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModSounds.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {


            MenuScreens.register(GEM_POLISHING_MENU.get(), GemPolishingStationScreen::new);
        }
    }
}
