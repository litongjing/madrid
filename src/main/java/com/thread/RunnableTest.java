package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午2:16 2018/5/31
 */
public class RunnableTest implements Runnable {
    private String name;

    public RunnableTest(String name) {
        this.name = name;
    }

    private synchronized void testSyncMethod() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.name+" "+Thread.currentThread().getId() + "testSyncMethod:" + i);
        }
    }

    private void testSyncBlock1() {
        synchronized (RunnableTest.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getId() + "testSyncBlock:" + i);
            }
        }
    }

    @Override
    public void run() {
//        testSyncMethod();
        testSyncBlock1();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(2);
        RunnableTest rt = new RunnableTest("hey");
        RunnableTest rt1 = new RunnableTest("hi");
        exec.execute(rt);
        exec.execute(rt1);
        exec.shutdown();
    }
}