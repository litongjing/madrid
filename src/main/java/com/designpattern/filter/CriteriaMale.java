package com.designpattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午4:22 2018/1/21
 */
public class CriteriaMale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if ("MALE".equalsIgnoreCase(person.getGender())) {
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}
