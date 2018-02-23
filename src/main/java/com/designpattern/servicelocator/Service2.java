package com.designpattern.servicelocator;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午5:00 2018/2/23
 */
public class Service2 implements Service {

    @Override
    public String getName() {
        return "service2";
    }

    @Override
    public void execute() {
        System.out.println("execute service2");
    }
}
