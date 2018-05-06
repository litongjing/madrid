package com.manager;

import com.alibaba.fastjson.JSONObject;
import com.domain.DO.AttributeDO;
import com.domain.DO.CampnouCouponDO;
import com.domain.DTO.CouponDTO;
import com.domain.dozerDO.DzDestinationDO;
import com.example.demo.MadridApplication;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午4:42 2017/12/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
//基本的所有配置都会通过入口类去加载，而注解可以引用入口类的配置
@SpringBootTest(classes = MadridApplication.class)
//@WebAppConfiguration
public class CouponManagerTest {
    @Autowired
    CouponManager couponManager;

    @Test
    public void test_selectCoupon() {
        CouponDTO couponDTO = new CouponDTO();
        //couponDTO.setCouponCode("5899937701012244");
        couponDTO.setStoreNo("HZ09");
        System.out.println(couponManager.selectCoupon(couponDTO));
    }

    @Test
    public void test_insertCoupon() {
        CampnouCouponDO campnouCouponDO = new CampnouCouponDO();
        campnouCouponDO.setAmount(BigDecimal.TEN);
        campnouCouponDO.setLeftAmount(BigDecimal.TEN);
        campnouCouponDO.setCouponCode("119");
        campnouCouponDO.setCouponName("101");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("open", "0");
        AttributeDO attributeDO = new AttributeDO();
        campnouCouponDO.setAttributes(attributeDO);
        int i = couponManager.insertCampnouCoupon(campnouCouponDO);
        if (i == 1) {
            System.out.println("success");
        } else {
            System.out.println("重复冲突");
        }
    }

    @Test
    public void test_select() {
        CampnouCouponDO campnouCouponDO = couponManager.selectCampnouCoupon(5L);
        AttributeDO attributeDO = campnouCouponDO.getAttributes();
        System.out.println(attributeDO.getA1());
    }

    @Test
    public void test_uuid() {
        System.out.println(UUID.randomUUID());
    }

    @Test
    public void test_tk_mybatis() {
        CampnouCouponDO campnouCouponDO = couponManager.selectCampnouCouponNew("4");

        System.out.println(campnouCouponDO);
    }

    @Test
    public void test_sqlHelp() {
    }
}