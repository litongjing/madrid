package com.designpattern.interceptingfilter;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午5:12 2018/2/23
 */
public class DebugFilter implements Filter {
    @Override
    public void execute(String request) {
        System.out.println("request log: " + request);
    }
}