package com.designpattern.interceptingfilter;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午5:15 2018/2/23
 */
public class FilterManager {
    FilterChain filterChain;

    public FilterManager(Target target) {
        filterChain = new FilterChain();
        filterChain.setTarget(target);
    }

    public void setFilter(Filter filter) {
        filterChain.addFilter(filter);
    }

    public void filterRequest(String request) {
        filterChain.execute(request);
    }
}
