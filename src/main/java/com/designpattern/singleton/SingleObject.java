package com.designpattern.singleton;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午6:48 2018/1/14
 */
public class SingleObject {
    //创建SingleObject的一个对象
    private static SingleObject instance = new SingleObject();//static 属于类

    //让构造函数私有化，这样类就不会被实例化
    private SingleObject() {

    }

    ;

    //获取唯一可用的对象
    public static SingleObject getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }

}
