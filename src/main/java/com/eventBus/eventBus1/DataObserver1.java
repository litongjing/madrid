package com.eventBus.eventBus1;

import com.google.common.eventbus.Subscribe;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午10:29 2018/3/19
 */
public class DataObserver1 {
    @Subscribe
    public void func(String msg){
        System.out.println("String msg:"+msg);
    }
}
