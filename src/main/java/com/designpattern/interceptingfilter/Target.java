package com.designpattern.interceptingfilter;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午5:12 2018/2/23
 */
public class Target {
    public void execute(String request) {
        System.out.println("Executing request: " + request);
    }
}