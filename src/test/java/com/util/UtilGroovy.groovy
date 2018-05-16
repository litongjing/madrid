package com.util

import com.domain.DO.AttributeDO
import com.domain.DO.CampnouCouponDO
import com.example.demo.MadridApplication
import com.manager.CouponManager
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午8:11 2018/5/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
//基本的所有配置都会通过入口类去加载，而注解可以引用入口类的配置
@SpringBootTest(classes = MadridApplication.class)
class UtilGroovy {
    @Autowired
    CouponManager couponManager;
     @Test
    void test_something(){
         CampnouCouponDO campnouCouponDO = couponManager.selectCampnouCoupon(5L);
         AttributeDO attributeDO = campnouCouponDO.getAttributes();
         println(attributeDO.getA1());
         def attr="123466";
         println(attr);
     }

}
