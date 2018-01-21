package com.designpattern.Decorator;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午3:58 2018/1/21
 */
public class BlinkMonk implements Hero {

    private String name;

    public BlinkMonk(String name) {
        this.name = name;
    }

    @Override
    public void learnSkills() {
        System.out.println(name + "学习了以上技能！");
    }
}