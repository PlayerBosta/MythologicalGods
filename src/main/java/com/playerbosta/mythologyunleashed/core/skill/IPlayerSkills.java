package com.playerbosta.mythologyunleashed.core.skill;


import com.playerbosta.mythologyunleashed.skill.PassiveSkill;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.capabilities.AutoRegisterCapability;
import net.minecraftforge.common.util.INBTSerializable;

@AutoRegisterCapability
public interface IPlayerSkills extends INBTSerializable<CompoundTag> {
  NonNullList<PassiveSkill> getPlayerSkills();

  boolean learnSkill(PassiveSkill passiveSkill);

  int getSkillPoints();

  void setSkillPoints(int skillPoints);

  void grantSkillPoints(int skillPoints);

  boolean isTreeReset();

  void setTreeReset(boolean reset);

  void resetTree(ServerPlayer player);
}
