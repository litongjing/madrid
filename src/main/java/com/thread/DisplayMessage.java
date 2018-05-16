package com.thread;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 上午12:18 2018/5/17
 */
public class DisplayMessage implements Runnable {
//    private int a=100;
    private String message;
    private RateLimiter rateLimiter=RateLimiter.create(100);

    public DisplayMessage(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        while(true) {
//            rateLimiter.acquire();
            System.out.println(message);
        }
    }
}