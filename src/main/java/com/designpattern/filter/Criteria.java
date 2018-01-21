package com.designpattern.filter;

import java.util.List;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午4:21 2018/1/21
 */
public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}
