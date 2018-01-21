package com.designpattern.abstractfactory;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 上午1:10 2018/1/14
 */
public class Red implements Color{

    @Override
    public void fill() {
        System.out.println("红色::fill");
    }
}
