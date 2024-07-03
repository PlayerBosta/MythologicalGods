package com.playerbosta.mythologyunleashed.core;

import com.playerbosta.mythologyunleashed.MythologyUnleashed;
import com.playerbosta.mythologyunleashed.core.message.LearnSkillMessage;
import com.playerbosta.mythologyunleashed.core.message.GainSkillPointMessage;
import com.playerbosta.mythologyunleashed.core.message.SyncPlayerSkillsMessage;
import com.playerbosta.mythologyunleashed.core.message.SyncServerDataMessage;
import java.util.Optional;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

@EventBusSubscriber(bus = Bus.MOD, modid = MythologyUnleashed.MODID)
public class NetworkDispatcher {
  public static SimpleChannel network_channel;

  @SubscribeEvent
  public static void registerNetworkChannel(FMLCommonSetupEvent event) {
    network_channel =
        NetworkRegistry.newSimpleChannel(
            new ResourceLocation(MythologyUnleashed.MODID, "channel"),
            () -> "1.0",
            s -> true,
            s -> true);
    network_channel.registerMessage(
        1,
        SyncServerDataMessage.class,
        SyncServerDataMessage::encode,
        SyncServerDataMessage::decode,
        SyncServerDataMessage::receive,
        Optional.of(NetworkDirection.PLAY_TO_CLIENT));
    network_channel.registerMessage(
        2,
        SyncPlayerSkillsMessage.class,
        SyncPlayerSkillsMessage::encode,
        SyncPlayerSkillsMessage::decode,
        SyncPlayerSkillsMessage::receive,
        Optional.of(NetworkDirection.PLAY_TO_CLIENT));
    network_channel.registerMessage(
        3,
        LearnSkillMessage.class,
        LearnSkillMessage::encode,
        LearnSkillMessage::decode,
        LearnSkillMessage::receive,
        Optional.of(NetworkDirection.PLAY_TO_SERVER));
    network_channel.registerMessage(
        4,
        GainSkillPointMessage.class,
        GainSkillPointMessage::encode,
        GainSkillPointMessage::decode,
        GainSkillPointMessage::receive,
        Optional.of(NetworkDirection.PLAY_TO_SERVER));
  }
}
