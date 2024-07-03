package com.playerbosta.mythologyunleashed.skill.extra;


import com.playerbosta.mythologyunleashed.client.screen.SkillTreeEditorScreen;
import com.playerbosta.mythologyunleashed.client.tooltip.TooltipHelper;
import com.playerbosta.mythologyunleashed.registers.PSTRegistries;
import java.util.Objects;
import java.util.function.Consumer;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

public interface SkillBonus<T extends SkillBonus<T>> extends Comparable<SkillBonus<?>> {
  default void onSkillLearned(ServerPlayer player, boolean firstTime) {}

  default void onSkillRemoved(ServerPlayer player) {}

  boolean canMerge(SkillBonus<?> other);

  default boolean sameBonus(SkillBonus<?> other) {
    return canMerge(other);
  }

  SkillBonus<T> merge(SkillBonus<?> other);

  SkillBonus<T> copy();

  T multiply(double multiplier);

  Serializer getSerializer();

  default String getDescriptionId() {
    ResourceLocation id = PSTRegistries.SKILL_BONUSES.get().getKey(getSerializer());
    Objects.requireNonNull(id);
    return "skill_bonus.%s.%s".formatted(id.getNamespace(), id.getPath());
  }

  MutableComponent getTooltip();

  default void gatherInfo(Consumer<MutableComponent> consumer) {
    TooltipHelper.consumeTranslated(getDescriptionId() + ".info", consumer);
  }

  boolean isPositive();

  void addEditorWidgets(SkillTreeEditorScreen editor, int index, Consumer<T> consumer);

  @Override
  default int compareTo(@NotNull SkillBonus<?> o) {
    if (isPositive() != o.isPositive()) {
      return isPositive() ? -1 : 1;
    }
    String regex = "\\+?-?[0-9]+\\.?[0-9]?%? ";
    String as = getTooltip().getString().replaceAll(regex, "");
    String bs = o.getTooltip().getString().replaceAll(regex, "");
    return as.compareTo(bs);
  }

  interface Ticking {
    void tick(ServerPlayer player);
  }

  enum Target {
    PLAYER,
    ENEMY
  }

  interface Serializer extends com.playerbosta.mythologyunleashed.data.serializers.Serializer<SkillBonus<?>> {
    SkillBonus<?> createDefaultInstance();
  }


}
