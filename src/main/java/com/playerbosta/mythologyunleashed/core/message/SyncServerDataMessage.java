package com.playerbosta.mythologyunleashed.core.message;

//import daripher.skilltree.data.reloader.GemTypesReloader;
import com.playerbosta.mythologyunleashed.data.reloader.SkillTreesReloader;
import com.playerbosta.mythologyunleashed.data.reloader.SkillsReloader;
import com.playerbosta.mythologyunleashed.core.NetworkHelper;
import java.util.function.Supplier;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class SyncServerDataMessage {
  public static SyncServerDataMessage decode(FriendlyByteBuf buf) {
    NetworkHelper.loadSkillTreeConfig(buf);
    SkillsReloader.loadFromByteBuf(buf);
    SkillTreesReloader.loadFromByteBuf(buf);
    //GemTypesReloader.loadFromByteBuf(buf);
    return new SyncServerDataMessage();
  }

  public static void receive(
      SyncServerDataMessage message, Supplier<NetworkEvent.Context> ctxSupplier) {
    ctxSupplier.get().setPacketHandled(true);
  }

  public void encode(FriendlyByteBuf buf) {
    NetworkHelper.writeSkillTreeConfig(buf);
    NetworkHelper.writePassiveSkills(buf, SkillsReloader.getSkills().values());
    NetworkHelper.writePassiveSkillTrees(buf, SkillTreesReloader.getSkillTrees().values());
    //NetworkHelper.writeGemTypes(buf, GemTypesReloader.getGemTypes().values());
  }
}
