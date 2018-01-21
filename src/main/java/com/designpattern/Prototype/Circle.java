package com.designpattern.Prototype;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午7:21 2018/1/14
 */
public class Circle extends Shape {
    public Circle() {
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("圆形：：draw");
    }
}
