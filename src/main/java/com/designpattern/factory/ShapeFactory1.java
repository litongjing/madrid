package com.designpattern.factory;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 上午12:54 2018/1/14
 */
public class ShapeFactory1 {
    public static Object getClass(Class<? extends Shape> clazz) {
        Object obj = null;
        try {
            obj = Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static void main(String[] args) {
        Rectangle rectangle = (Rectangle) ShapeFactory1.getClass(Rectangle.class);
        rectangle.draw();
        Circle circle = (Circle) ShapeFactory1.getClass(Circle.class);
        circle.draw();
    }
}
