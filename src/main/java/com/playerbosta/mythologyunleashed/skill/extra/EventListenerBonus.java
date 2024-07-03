package com.playerbosta.mythologyunleashed.skill.extra;

import com.playerbosta.mythologyunleashed.skill.extra.event.SkillEventListener;
import com.playerbosta.mythologyunleashed.skill.extra.event.SkillLearnedEventListener;
import com.playerbosta.mythologyunleashed.skill.extra.event.SkillRemovedEventListener;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;

public interface EventListenerBonus<T> extends SkillBonus<EventListenerBonus<T>> {
  @Override
  default void onSkillLearned(ServerPlayer player, boolean firstTime) {
    if (firstTime && getEventListener() instanceof SkillLearnedEventListener listener) {
      //listener.onEvent(player, this);
    }
  }

  @Override
  default void onSkillRemoved(ServerPlayer player) {
    if (getEventListener() instanceof SkillRemovedEventListener listener) {
      listener.onEvent(player, this);
    }
  }


  SkillEventListener getEventListener();

  void applyEffect(LivingEntity target);
}
