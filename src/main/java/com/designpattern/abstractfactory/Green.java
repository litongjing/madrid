package com.designpattern.abstractfactory;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 上午1:12 2018/1/14
 */
public class Green implements Color{
    @Override
    public void fill() {
        System.out.println("绿色::fill");
    }
}
