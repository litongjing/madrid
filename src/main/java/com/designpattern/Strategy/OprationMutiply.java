package com.designpattern.Strategy;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午3:31 2018/1/19
 */
public class OprationMutiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
