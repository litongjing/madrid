package com.others.jodd;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 上午10:33 2018/2/11
 */
public class Foo {
    private String readwrite;
    private String readonly;

    public String getReadwrite() {
        return readwrite;
    }

    public void setReadwrite(String readwrite) {
        this.readwrite = readwrite;
    }

    public String getReadonly() {
        return readonly;
    }

    public void setReadonly(String readonly) {
        this.readonly = readonly;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "readwrite='" + readwrite + '\'' +
                ", readonly='" + readonly + '\'' +
                '}';
    }
}
