package com.designpattern.abstractfactory;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 上午12:39 2018/1/14
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("长方形::draw");
    }
}
