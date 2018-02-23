package com.others.jodd;

import jodd.bean.BeanUtil;
import jodd.typeconverter.TypeConverterManager;
import org.junit.Test;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 上午10:19 2018/2/11
 */
public class JoddTest {
    @Test
    public void test_1() {
        Foo foo = new Foo();
        BeanUtil.pojo.setProperty(foo, "readwrite", "hi");
//        BeanUtil.pojo.setProperty(foo,"readonly","hi~");

        BeanUtil.declared.setProperty(foo, "readonly", "data");
        System.out.println(foo);
    }

    @Test
    public void test_2() {
        Foo foo = new Foo();
        System.out.println(foo);
    }
}
