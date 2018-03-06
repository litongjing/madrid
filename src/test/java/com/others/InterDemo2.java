package com.others;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午9:38 2018/2/24
 */
public class InterDemo2 implements InterDemo1{
    @Override
    public String myString1() {
        return "hehe";
    }

    @Override
    public String myString() {
        return "haha";
    }

    public static void main(String[] args) {
        InterDemo2 interDemo2=new InterDemo2();
        System.out.println(interDemo2.myString());
        System.out.println(interDemo2.myString());
    }
}
