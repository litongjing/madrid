package com.apache;

import com.annotation.demo1.Column;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 上午12:47 2018/2/4
 */
public class commons {
    @Test
    public void test_lang(){
        System.out.println(StringUtils.substringAfter("select * from  person", "from"));

        System.out.println(StringUtils.isNumeric("123124A215"));

        System.out.println(ClassUtils.getShortClassName(Column.class));

        System.out.println(RandomStringUtils.randomAlphanumeric(5));

        System.out.println(StringEscapeUtils.escapeJava("String"));

        System.out.println(StringUtils.isBlank(" "));

        String[] str={"1","2"};
        System.out.println(StringUtils.join(str, "@"));




    }
}
