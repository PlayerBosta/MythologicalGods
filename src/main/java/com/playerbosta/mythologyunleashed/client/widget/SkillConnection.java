package com.playerbosta.mythologyunleashed.client.widget;

public class SkillConnection {
  private final Type type;
  private final SkillButton button1;
  private final SkillButton button2;

  public SkillConnection(Type type, SkillButton button1, SkillButton button2) {
    this.type = type;
    this.button1 = button1;
    this.button2 = button2;
  }

  public SkillButton getFirstButton() {
    return button1;
  }

  public SkillButton getSecondButton() {
    return button2;
  }

  public Type getType() {
    return type;
  }

  public enum Type {
    DIRECT,
    LONG,
    ONE_WAY
  }
}
