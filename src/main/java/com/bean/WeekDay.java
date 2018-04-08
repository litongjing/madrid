package com.bean;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 上午11:56 2018/1/22
 */
public enum WeekDay {
    SUN(7, "sunday"), MON(1, "monday");


    private int value;
    private String name;

    private WeekDay(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static void main(String[] args) {
        System.out.println("~~~~~");
        System.out.println("~~");
        System.out.println(WeekDay.MON.value);
    }
}
