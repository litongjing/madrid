package com.designpattern.frontcontroller;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午5:22 2018/2/23
 */
public class Dispatcher {
    private StudentView studentView;
    private HomeView homeView;

    public Dispatcher() {
        studentView = new StudentView();
        homeView = new HomeView();
    }

    public void dispatch(String request) {
        if (request.equalsIgnoreCase("STUDENT")) {
            studentView.show();
        } else {
            homeView.show();
        }
    }
}
