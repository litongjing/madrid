package com.designpattern.abstractfactory;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 上午12:41 2018/1/14
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("圆形::draw");
    }
}
