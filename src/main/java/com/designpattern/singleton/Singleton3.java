package com.designpattern.singleton;

/**
 * @Author:LiTongjing
 * @Description:双检锁/双重校验锁（DCL，即 double-checked locking）
 * @Date:Create by 下午7:04 2018/1/14
 */
public class Singleton3 {
    private volatile static Singleton3 singleton;

    private Singleton3() {
    }

    public static Singleton3 getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton3();
                }
            }
        }
        return singleton;
    }
}
