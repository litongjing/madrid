package com.designpattern.interceptingfilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午5:13 2018/2/23
 */
public class FilterChain {
    private List<Filter> filters = new ArrayList<Filter>();
    private Target target;

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public void execute(String request) {
        for (Filter filter : filters) {
            filter.execute(request);
        }
        target.execute(request);
    }

    public void setTarget(Target target) {
        this.target = target;
    }
}
