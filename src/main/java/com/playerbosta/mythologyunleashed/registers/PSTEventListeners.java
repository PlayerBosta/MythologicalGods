package com.playerbosta.mythologyunleashed.registers;


import com.playerbosta.mythologyunleashed.MythologyUnleashed;
import com.playerbosta.mythologyunleashed.client.tooltip.TooltipHelper;
import com.playerbosta.mythologyunleashed.skill.extra.event.*;
import java.util.List;
import java.util.Objects;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PSTEventListeners {
  public static final ResourceLocation REGISTRY_ID =
      new ResourceLocation(MythologyUnleashed.MODID, "event_listeners");
  public static final DeferredRegister<SkillEventListener.Serializer> REGISTRY =
      DeferredRegister.create(REGISTRY_ID, MythologyUnleashed.MODID);
/*
  public static final RegistryObject<SkillEventListener.Serializer> ATTACK =
      REGISTRY.register("attack", AttackEventListener.Serializer::new);
  public static final RegistryObject<SkillEventListener.Serializer> BLOCK =
      REGISTRY.register("block", BlockEventListener.Serializer::new);
  public static final RegistryObject<SkillEventListener.Serializer> EVASION =
      REGISTRY.register("evasion", EvasionEventListener.Serializer::new);
  public static final RegistryObject<SkillEventListener.Serializer> ITEM_USED =
      REGISTRY.register("item_used", ItemUsedEventListener.Serializer::new);
  public static final RegistryObject<SkillEventListener.Serializer> DAMAGE_TAKEN =
      REGISTRY.register("damage_taken", DamageTakenEventListener.Serializer::new);
  public static final RegistryObject<SkillEventListener.Serializer> ON_KILL =
      REGISTRY.register("on_kill", KillEventListener.Serializer::new);

 */
  public static final RegistryObject<SkillEventListener.Serializer> SKILL_LEARNED =
      REGISTRY.register("skill_learned", SkillLearnedEventListener.Serializer::new);
  public static final RegistryObject<SkillEventListener.Serializer> SKILL_REMOVED =
     REGISTRY.register("skill_removed", SkillRemovedEventListener.Serializer::new);

  public static List<SkillEventListener> eventsList() {
    return PSTRegistries.EVENT_LISTENERS.get().getValues().stream()
        .map(SkillEventListener.Serializer::createDefaultInstance)
        .toList();
  }

  public static String getName(SkillEventListener eventType) {
    ResourceLocation id = PSTRegistries.EVENT_LISTENERS.get().getKey(eventType.getSerializer());
    return TooltipHelper.idToName(Objects.requireNonNull(id).getPath());
  }
}
