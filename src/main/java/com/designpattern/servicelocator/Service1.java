package com.designpattern.servicelocator;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午4:59 2018/2/23
 */
public class Service1 implements Service {
    @Override
    public String getName() {
        return "service1";
    }

    @Override
    public void execute() {
        System.out.println("execute service1");
    }
}
