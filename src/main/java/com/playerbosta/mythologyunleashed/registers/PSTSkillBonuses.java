package com.playerbosta.mythologyunleashed.registers;

import com.playerbosta.mythologyunleashed.MythologyUnleashed;
import com.playerbosta.mythologyunleashed.client.tooltip.TooltipHelper;
import com.playerbosta.mythologyunleashed.skill.extra.SkillBonus;
import com.playerbosta.mythologyunleashed.skill.extra.player.*;
import java.util.List;
import java.util.Objects;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.*;

public class PSTSkillBonuses {
  public static final ResourceLocation REGISTRY_ID =
      new ResourceLocation(MythologyUnleashed.MODID, "skill_bonuses");
  public static final DeferredRegister<SkillBonus.Serializer> REGISTRY =
      DeferredRegister.create(REGISTRY_ID, MythologyUnleashed.MODID);


  public static final RegistryObject<SkillBonus.Serializer> ATTRIBUTE =
      REGISTRY.register("attribute", AttributeBonus.Serializer::new);

  public static final RegistryObject<SkillBonus.Serializer> COMMAND =
      REGISTRY.register("command", CommandBonus.Serializer::new);
  /*
  public static final RegistryObject<SkillBonus.Serializer> DAMAGE =
      REGISTRY.register("damage", DamageBonus.Serializer::new);
  public static final RegistryObject<SkillBonus.Serializer> CRIT_DAMAGE =
      REGISTRY.register("crit_damage", CritDamageBonus.Serializer::new);
  public static final RegistryObject<SkillBonus.Serializer> CRIT_CHANCE =
      REGISTRY.register("crit_chance", CritChanceBonus.Serializer::new);
  public static final RegistryObject<SkillBonus.Serializer> CRAFTED_ITEM_BONUS =
      REGISTRY.register("crafted_item_bonus", CraftedItemBonus.Serializer::new);
  public static final RegistryObject<SkillBonus.Serializer> GEM_POWER =
      REGISTRY.register("gem_power", GemPowerBonus.Serializer::new);
  public static final RegistryObject<SkillBonus.Serializer> PLAYER_SOCKETS =
      REGISTRY.register("player_sockets", PlayerSocketsBonus.Serializer::new);
  public static final RegistryObject<SkillBonus.Serializer> REPAIR_EFFICIENCY =
      REGISTRY.register("repair_efficiency", RepairEfficiencyBonus.Serializer::new);
  public static final RegistryObject<SkillBonus.Serializer> BLOCK_BREAK_SPEED =
      REGISTRY.register("block_break_speed", BlockBreakSpeedBonus.Serializer::new);
  public static final RegistryObject<SkillBonus.Serializer> RECIPE_UNLOCK =
      REGISTRY.register("recipe_unlock", RecipeUnlockBonus.Serializer::new);
  public static final RegistryObject<SkillBonus.Serializer> ENCHANTMENT_AMPLIFICATION =
      REGISTRY.register("enchantment_amplification", EnchantmentAmplificationBonus.Serializer::new);
  public static final RegistryObject<SkillBonus.Serializer> ENCHANTMENT_REQUIREMENT =
      REGISTRY.register("enchantment_requirement", EnchantmentRequirementBonus.Serializer::new);
  public static final RegistryObject<SkillBonus.Serializer> FREE_ENCHANTMENT =
      REGISTRY.register("free_enchantment", FreeEnchantmentBonus.Serializer::new);
  public static final RegistryObject<SkillBonus.Serializer> JUMP_HEIGHT =
      REGISTRY.register("jump_height", JumpHeightBonus.Serializer::new);
  public static final RegistryObject<SkillBonus.Serializer> INCOMING_HEALING =
      REGISTRY.register("incoming_healing", IncomingHealingBonus.Serializer::new);
  public static final RegistryObject<SkillBonus.Serializer> LOOT_DUPLICATION =
      REGISTRY.register("loot_duplication", LootDuplicationBonus.Serializer::new);
  public static final RegistryObject<SkillBonus.Serializer> GAINED_EXPERIENCE =
      REGISTRY.register("gained_experience", GainedExperienceBonus.Serializer::new);
  public static final RegistryObject<SkillBonus.Serializer> IGNITE =
      REGISTRY.register("ignite", IgniteBonus.Serializer::new);
  public static final RegistryObject<SkillBonus.Serializer> ARROW_RETRIEVAL =
      REGISTRY.register("arrow_retrieval", ArrowRetrievalBonus.Serializer::new);
  public static final RegistryObject<SkillBonus.Serializer> HEALTH_RESERVATION =
      REGISTRY.register("health_reservation", HealthReservationBonus.Serializer::new);
  public static final RegistryObject<SkillBonus.Serializer> ALL_ATTRIBUTES =
      REGISTRY.register("all_attributes", AllAttributesBonus.Serializer::new);
  public static final RegistryObject<SkillBonus.Serializer> MOB_EFFECT =
      REGISTRY.register("mob_effect", MobEffectBonus.Serializer::new);
  public static final RegistryObject<SkillBonus.Serializer> CANT_USE_ITEM =
      REGISTRY.register("cant_use_item", CantUseItemBonus.Serializer::new);
  public static final RegistryObject<SkillBonus.Serializer> HEALING =
      REGISTRY.register("healing", HealingBonus.Serializer::new);
  public static final RegistryObject<SkillBonus.Serializer> INFLICT_DAMAGE =
      REGISTRY.register("inflict_damage", InflictDamageBonus.Serializer::new);
*/
  @SuppressWarnings("rawtypes")
  public static List<SkillBonus> bonusList() {
    return PSTRegistries.SKILL_BONUSES.get().getValues().stream()
        .map(SkillBonus.Serializer::createDefaultInstance)
        .map(SkillBonus.class::cast)
        .toList();
  }

  public static String getName(SkillBonus<?> bonus) {
    ResourceLocation id = PSTRegistries.SKILL_BONUSES.get().getKey(bonus.getSerializer());
    return TooltipHelper.idToName(Objects.requireNonNull(id).getPath());
  }
}
