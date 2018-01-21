package com.designpattern.Strategy;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午3:48 2018/1/19
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new OprationAdd());
        System.out.println(context.executeStrategy(4, 2));
        context = new Context(new OprationSubstract());
        System.out.println(context.executeStrategy(4, 2));
        context = new Context(new OprationMutiply());
        System.out.println(context.executeStrategy(4, 2));
    }
}
