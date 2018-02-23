package com.designpattern.commod;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午4:31 2018/2/23
 */
public class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.sell();
    }
}
