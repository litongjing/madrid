package com.eventBus.eventBus1;

import com.google.common.eventbus.EventBus;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午10:26 2018/3/19
 */
public class EventBusCenter {
    public static EventBus eventBus = new EventBus();

    private EventBusCenter() {

    }

    public static EventBus getInstance() {
        return eventBus;
    }

    public static void register(Object obj) {
        eventBus.register(obj);
    }

    public static void unregister(Object obj) {
        eventBus.unregister(obj);
    }

    public static void post(Object obj) {
        eventBus.post(obj);
    }
}
