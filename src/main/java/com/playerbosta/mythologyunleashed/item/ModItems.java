package com.playerbosta.mythologyunleashed.item;

import com.playerbosta.mythologyunleashed.MythologyUnleashed;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MythologyUnleashed.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}