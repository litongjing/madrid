package com.designpattern.commod;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午4:34 2018/2/23
 */
public class Broker {
    private List<Order> orderList = Lists.newArrayList();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrders() {
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }


    public static void main(String[] args) {
        Stock abcStock = new Stock();

        BuyStock buyStock = new BuyStock(abcStock);
        SellStock sellStock = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStock);
        broker.takeOrder(sellStock);

        broker.placeOrders();
    }
}
