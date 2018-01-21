package com.designpattern.singleton;

/**
 * @Author:LiTongjing
 * @Description:饿汉式
 * @Date:Create by 下午7:02 2018/1/14
 */
public class Singleton2 {
    private static Singleton2 instance = new Singleton2();

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}
