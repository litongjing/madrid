package com.util;

/**
 * Created by wzy on 2017/5/24.
 */
public class DataSourceHolder {
    private static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void setDataSource(String dataSource) {
        holder.set(dataSource);
    }

    public static String getDataSource() {
        return holder.get();
    }
}
