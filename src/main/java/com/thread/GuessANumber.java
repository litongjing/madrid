package com.thread;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 上午12:18 2018/5/17
 */
public class GuessANumber extends Thread {
    private int number;
    public GuessANumber(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(1);
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        int counter = 0;
//        int guess = 0;
//        do {
//            guess = (int) (Math.random() * 100 + 1);
//            System.out.println(this.getName() + " guesses " + guess);
//            counter++;
//        } while(guess != number);
//        System.out.println("** Correct!" + this.getName() + "in" + counter + "guesses.**");
    }
}
