package com.playerbosta.mythologyunleashed.registers;

import com.playerbosta.mythologyunleashed.MythologyUnleashed;
import com.playerbosta.mythologyunleashed.skill.extra.SkillBonus;
/*
import daripher.skilltree.item.gem.bonus.GemBonusProvider;
import daripher.skilltree.skill.bonus.condition.damage.DamageCondition;
import daripher.skilltree.skill.bonus.condition.enchantment.EnchantmentCondition;
import daripher.skilltree.skill.bonus.condition.item.ItemCondition;
import daripher.skilltree.skill.bonus.condition.living.LivingCondition;
import daripher.skilltree.skill.bonus.event.SkillEventListener;
import daripher.skilltree.skill.bonus.item.ItemBonus;
import daripher.skilltree.skill.bonus.multiplier.LivingMultiplier;

 */
import java.util.function.Supplier;

import com.playerbosta.mythologyunleashed.skill.extra.event.SkillEventListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.NewRegistryEvent;
import net.minecraftforge.registries.RegistryBuilder;

@Mod.EventBusSubscriber(modid = MythologyUnleashed.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PSTRegistries {
  public static final Supplier<IForgeRegistry<SkillBonus.Serializer>> SKILL_BONUSES =
      PSTSkillBonuses.REGISTRY.makeRegistry(RegistryBuilder::new);
  /*
  public static final Supplier<IForgeRegistry<LivingMultiplier.Serializer>> LIVING_MULTIPLIERS =
      PSTLivingMultipliers.REGISTRY.makeRegistry(RegistryBuilder::new);
  public static final Supplier<IForgeRegistry<LivingCondition.Serializer>> LIVING_CONDITIONS =
      PSTLivingConditions.REGISTRY.makeRegistry(RegistryBuilder::new);
  public static final Supplier<IForgeRegistry<DamageCondition.Serializer>> DAMAGE_CONDITIONS =
      PSTDamageConditions.REGISTRY.makeRegistry(RegistryBuilder::new);
  public static final Supplier<IForgeRegistry<ItemCondition.Serializer>> ITEM_CONDITIONS =
      PSTItemConditions.REGISTRY.makeRegistry(RegistryBuilder::new);
  public static final Supplier<IForgeRegistry<ItemBonus.Serializer>> ITEM_BONUSES =
      PSTItemBonuses.REGISTRY.makeRegistry(RegistryBuilder::new);
  public static final Supplier<IForgeRegistry<EnchantmentCondition.Serializer>> ENCHANTMENT_CONDITIONS =
      PSTEnchantmentConditions.REGISTRY.makeRegistry(RegistryBuilder::new);
  public static final Supplier<IForgeRegistry<GemBonusProvider.Serializer>> GEM_BONUSES =
      PSTGemBonuses.REGISTRY.makeRegistry(RegistryBuilder::new);

   */
  public static final Supplier<IForgeRegistry<SkillEventListener.Serializer>> EVENT_LISTENERS =
      PSTEventListeners.REGISTRY.makeRegistry(RegistryBuilder::new);

  @SubscribeEvent
  public static void registerRegistries(NewRegistryEvent event) {
    createRegistry(event, PSTSkillBonuses.REGISTRY_ID);
    /*createRegistry(event, PSTLivingMultipliers.REGISTRY_ID);
    createRegistry(event, PSTLivingConditions.REGISTRY_ID);
    createRegistry(event, PSTDamageConditions.REGISTRY_ID);
    createRegistry(event, PSTItemConditions.REGISTRY_ID);
    createRegistry(event, PSTItemBonuses.REGISTRY_ID);
    createRegistry(event, PSTEnchantmentConditions.REGISTRY_ID);
    createRegistry(event, PSTGemBonuses.REGISTRY_ID);

     */
    createRegistry(event, PSTEventListeners.REGISTRY_ID);
  }

  private static <T> void createRegistry(NewRegistryEvent event, ResourceLocation id) {
    event.create(new RegistryBuilder<T>().setName(id));
  }
}
