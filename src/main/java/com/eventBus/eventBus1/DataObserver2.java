package com.eventBus.eventBus1;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午10:30 2018/3/19
 */
public class DataObserver2 {
    @Subscribe
    public void func(Integer msg) {
        System.out.println("Integer msg: " + msg);
    }

    @Subscribe
    @AllowConcurrentEvents
    public void func1(Integer msg1){
        System.out.println("Integer msg111: " + msg1);
    }

    public static void main(String[] args) {
        DataObserver1 dataObserver1=new DataObserver1();
        DataObserver2 dataObserver2=new DataObserver2();
        EventBusCenter.register(dataObserver1);
        EventBusCenter.register(dataObserver2);
        System.out.println("1~~~~~");
        EventBusCenter.post("I'm String");
        EventBusCenter.post(1);
        System.out.println("1~~~~~");
        EventBusCenter.post("I'm String~~");
        EventBusCenter.post(2);
    }
}
