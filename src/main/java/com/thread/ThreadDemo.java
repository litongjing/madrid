package com.thread;

public class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;

    ThreadDemo(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.threadName+"___");
        }
//        System.out.println("Running " + threadName);
//        try {
//            for (int i = 4; i > 0; i--) {
//                System.out.println("Thread: " + threadName + ", " + i);
//                // 让线程睡眠一会
//                Thread.sleep(50);
//            }
//        } catch (InterruptedException e) {
//            System.out.println("Thread " + threadName + " interrupted.");
//        }
//        System.out.println("Thread " + threadName + " exiting.");
    }

//    @Override
//    public void start() {
//        for(int i=0;i<10;i++){
//            System.out.println(this.threadName+"~~~");
//        }

//        System.out.println("Starting " + threadName);
//        if (t == null) {
//            t = new Thread(this, threadName);
//            t.start();
//        }
//    }


    public static void main(String[] args) {
        ThreadDemo T1 = new ThreadDemo("Thread-1");
        T1.start();

        ThreadDemo T2 = new ThreadDemo("Thread-2");
        T2.start();
    }
}