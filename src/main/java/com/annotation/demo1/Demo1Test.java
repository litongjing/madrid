package com.annotation.demo1;

import com.annotation.DataImpl;
import com.annotation.DataInterface;
import scala.annotation.meta.field;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 上午11:17 2018/2/2
 */
public class Demo1Test {
    public static void main(String[] args) {
        Filter f1 = new Filter();
        Filter f2 = new Filter();
        f1.setId(1);
        f1.setName("ltj");
        f2.setId(2);
        f2.setName("xavi");
        System.out.println(query(f1));
    }

    private static String query(Object obj) {
        Table table = obj.getClass().getAnnotation(Table.class);
        StringBuffer sbSql = new StringBuffer();
        String tableName = table.value();
        sbSql.append("select * from " + tableName + " where 1=1 ");
        Field[] fileds = obj.getClass().getDeclaredFields();
        for (Field f : fileds) {
            String fieldName = f.getName();
            String methodName = "get" + fieldName.substring(0, 1).toUpperCase()
                    + fieldName.substring(1);
            try {
                Column column = f.getAnnotation(Column.class);
                if (column != null) {
                    Method method = obj.getClass().getMethod(methodName);
                    String value = (String) method.invoke(obj);
                    if (value != null && !value.equals("")) {
                        if (!isNum(column.value()) && !isNum(value)) {
                            // 判断参数是不是 in 类型参数 1,2,3
                            if (value.contains(",")) {
                                sbSql.append(" and " + column.value() + " in (" + value + ") ");
                            } else {
                                sbSql.append(" and " + column.value() + " like '%" + value + "%' ");
                            }
                        } else {
                            sbSql.append(" and " + column.value() + "=" + value + " ");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sbSql.toString();
    }

    public static boolean isNum(String target) {
        boolean isNum = false;
        if (target.toLowerCase().contains("id")) {
            isNum = true;
        }
        if (target.matches("\\d+")) {
            isNum = true;
        }
        return isNum;
    }
}
