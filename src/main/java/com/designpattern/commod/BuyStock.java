package com.designpattern.commod;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午4:30 2018/2/23
 */
public class BuyStock implements Order {
    private Stock abcStock;

    public BuyStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }
}
