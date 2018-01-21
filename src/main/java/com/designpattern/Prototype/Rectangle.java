package com.designpattern.Prototype;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午7:15 2018/1/14
 */
public class Rectangle extends Shape {

    public Rectangle() {
        type = "Rectangle";
    }


    @Override
    void draw() {
        System.out.println("长方形：：draw");
    }
}
