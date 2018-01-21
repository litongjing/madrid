package com.designpattern.Prototype;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午7:18 2018/1/14
 */
public class Square extends Shape {
    public Square() {
        type = "Square";
    }


    @Override
    void draw() {
        System.out.println("正方形：：draw");
    }
}
