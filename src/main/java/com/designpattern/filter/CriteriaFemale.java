package com.designpattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午4:35 2018/1/21
 */
public class CriteriaFemale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> list = new ArrayList<Person>();
        for (Person person : persons) {
            if ("FEMALE".equalsIgnoreCase(person.getGender())) {
                list.add(person);
            }
        }
        return list;
    }
}
