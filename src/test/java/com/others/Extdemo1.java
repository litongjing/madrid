package com.others;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午9:31 2018/2/24
 */
public class Extdemo1 extends Extdemo {
    @Override
    public String myString() {
        return "hello !";
    }

    public static void main(String[] args) {
          Extdemo1 extdemo1=new Extdemo1();
        System.out.println(extdemo1.myString());
        System.out.println(extdemo1.myRealString());
    }
}
