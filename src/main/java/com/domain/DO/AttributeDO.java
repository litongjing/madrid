package com.domain.DO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.Attribute;
import java.util.Date;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午8:28 2018/2/7
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttributeDO {
    private String a1;
    private String a2;
    private Date date;

    public static void main(String[] args) {
        AttributeDO attributeDO = new AttributeDO();
        AttributeDO attributeDO1 = new AttributeDO("1", "2", new Date());
        Date date = new Date();
        attributeDO.setDate(date);
        attributeDO.setA1("1");
        attributeDO.setA2("2");
        System.out.println(attributeDO);
        System.out.println(attributeDO1);
        AttributeDO attributeDO2=AttributeDO.builder().a1("1").a2("2").build();
        System.out.println("@@@@@");
        System.out.println(attributeDO2);
    }
}
