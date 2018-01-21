package com.designpattern.Strategy;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午3:46 2018/1/19
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
