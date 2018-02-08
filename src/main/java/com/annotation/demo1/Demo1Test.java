package com.annotation.demo1;

import com.annotation.DataImpl;
import com.annotation.DataInterface;

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
    }

    private static String query(Object f) {
        StringBuilder sql = new StringBuilder();
        Class c = f.getClass();
        boolean exist = c.isAnnotationPresent(Table.class);
        if (!exist) {
            return null;
        }
        Table t = (Table) c.getAnnotation(Table.class);
        String tableName = t.value();
        sql.append("select * from ").append(tableName).append(" where 1=1 ");
        return null;
    }

//    public static void main(String[] args) {
//        DataImpl data=new DataImpl();
//        Class<?> clazz = DataImpl.class;
//        System.out.println(1);
//        System.out.println(DataInterface.class.isAssignableFrom(clazz));
//        System.out.println(2);
//        System.out.println(data instanceof DataImpl);
//
//    }
}
