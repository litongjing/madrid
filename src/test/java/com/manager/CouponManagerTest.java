package com.manager;

import com.domain.DTO.CouponDTO;
import com.example.demo.MadridApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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
    public void test_selectCoupon(){
        CouponDTO couponDTO=new CouponDTO();
        couponDTO.setCouponCode("5899937701012244");
        System.out.println(couponManager.selectCoupon(couponDTO));
    }
}