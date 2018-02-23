package com.designpattern.commod;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午4:29 2018/2/23
 */
public class Stock {
    private String name = "ABC";
    private int quantity = 10;

    public void buy() {
        System.out.println("Stock [ Name: " + name + ",Quantity:" + quantity + " ]bought ");
    }

    public void sell() {
        System.out.println("Stock [ Name: " + name + ",Quantity:" + quantity + " ]sold ");
    }
}
