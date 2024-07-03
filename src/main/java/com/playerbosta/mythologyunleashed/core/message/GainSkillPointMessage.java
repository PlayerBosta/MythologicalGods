package com.playerbosta.mythologyunleashed.core.message;


import com.playerbosta.mythologyunleashed.core.skill.PlayerSkillsProvider;
import com.playerbosta.mythologyunleashed.core.skill.IPlayerSkills;
import com.playerbosta.mythologyunleashed.config.Config;
import com.playerbosta.mythologyunleashed.core.NetworkDispatcher;

import java.util.Objects;
import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkEvent.Context;
import net.minecraftforge.network.PacketDistributor;

public class GainSkillPointMessage {
  public static GainSkillPointMessage decode(FriendlyByteBuf buf) {
    return new GainSkillPointMessage();
  }

  public static void receive(
      GainSkillPointMessage message, Supplier<NetworkEvent.Context> ctxSupplier) {
    Context ctx = ctxSupplier.get();
    ctx.setPacketHandled(true);
    ServerPlayer player = Objects.requireNonNull(ctx.getSender());
    IPlayerSkills capability = PlayerSkillsProvider.get(player);
    int skills = capability.getPlayerSkills().size();
    int points = capability.getSkillPoints();
    int level = skills + points;
    if (level >= Config.max_skill_points) return;
    int cost = Config.getSkillPointCost(level);
    if (player.totalExperience < cost) return;
    player.giveExperiencePoints(-cost);
    capability.grantSkillPoints(1);
    NetworkDispatcher.network_channel.send(
        PacketDistributor.PLAYER.with(() -> player), new SyncPlayerSkillsMessage(player));
  }

  public void encode(FriendlyByteBuf buf) {}
}
