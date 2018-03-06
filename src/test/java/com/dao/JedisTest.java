package com.dao;

import com.domain.DO.CouponDO;
import com.domain.DTO.CouponDTO;
import com.example.demo.MadridApplication;
import com.manager.CouponManager;
import com.util.SerializeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午5:46 2017/12/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
//基本的所有配置都会通过入口类去加载，而注解可以引用入口类的配置
@SpringBootTest(classes = MadridApplication.class)
//@WebAppConfiguration
@Slf4j
public class JedisTest {
    private Jedis jedis;
    @Autowired
    CouponManager couponManager;

    @Before
    public void setup() {
//        jedis = new Jedis("192.168.130.7", 6379);
//        jedis.auth("intimednb");

        jedis=new Jedis("47.97.175.43",6379);
        jedis.auth("little");
    }

    @Test
    public void test_1() {
        CouponDTO couponDTO = new CouponDTO();
        couponDTO.setCouponCode("5899937701012244");
        CouponDO couponDO = couponManager.selectCoupon(couponDTO);
        jedis.set("coupon".getBytes(), SerializeUtil.serialize(couponDO));
        System.out.println((CouponDO) SerializeUtil.unserialize(jedis.get("coupon".getBytes())));

//        jedis.flushAll();
    }
}
