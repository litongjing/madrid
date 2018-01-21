package com.designpattern.abstractfactory;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 上午1:14 2018/1/14
 */
public abstract class AbstractFactory {
    abstract Color getColor(String color);

    abstract Shape getShape(String shape);
}
