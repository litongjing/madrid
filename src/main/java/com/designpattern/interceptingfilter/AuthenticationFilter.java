package com.designpattern.interceptingfilter;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午5:11 2018/2/23
 */
public class AuthenticationFilter implements Filter {
    
    @Override
    public void execute(String request) {
        System.out.println("Authenticating request: " + request);
    }
}