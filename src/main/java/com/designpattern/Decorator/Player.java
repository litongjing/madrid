package com.designpattern.Decorator;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午4:07 2018/1/21
 */
public class Player {
    public static void main(String[] args) {
        Hero hero = new BlinkMonk("李青");
        Skills skills = new Skills(hero);
        Skills q = new Skill_Q(skills, "天音波/回音击");
        Skills w = new Skill_W(q, "金钟罩/铁布衫");

        //学习技能
        q.learnSkills();
        w.learnSkills();
    }
}
