package com.designpattern.Decorator;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午4:02 2018/1/21
 */
public class Skill_Q extends Skills {

    private String skillName;

    public Skill_Q(Hero hero, String skillName) {
        super(hero);
        this.skillName = skillName;
    }

    @Override
    public void learnSkills() {
        System.out.println("学习了技能Q:" + skillName);
        super.learnSkills();
    }
}
