package com.designpattern.Decorator;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午4:00 2018/1/21
 */
//Decorator 技能栏
public class Skills implements Hero {
    //持有一个英雄对象接口
    private Hero hero;

    public Skills(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void learnSkills() {
        if (hero != null)
            hero.learnSkills();
    }
}
