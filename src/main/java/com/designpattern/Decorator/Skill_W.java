package com.designpattern.Decorator;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午4:04 2018/1/21
 */
public class Skill_W extends Skills {

    private String skillName;

    public Skill_W(Hero hero, String skillName) {
        super(hero);
        this.skillName = skillName;
    }

    @Override
    public void learnSkills() {
        System.out.println("学习了技能W:" + skillName);
        super.learnSkills();
    }
}

