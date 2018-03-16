package com.dao.cache;

import com.dao.redisCache.JedisWrapper;
import com.dao.redisCache.RedisClientFactory;
import com.domain.DO.CouponDO;
import com.example.demo.MadridApplication;
import com.util.util.SerializeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.util.Set;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午6:52 2018/3/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
//基本的所有配置都会通过入口类去加载，而注解可以引用入口类的配置
@SpringBootTest(classes = MadridApplication.class)
//@WebAppConfiguration
@Slf4j
public class redisFactoryTest {
    private JedisWrapper jedisnew;

    @Before
    public void before() {
//        jedisnew = RedisClientFactory.getJedis();
         jedisnew = RedisClientFactory.getJedis();
    }

    @Test
    public void test_1() {
                CouponDO couponDO=new CouponDO();
        couponDO.setCouponCode("123455");
        for(int i=0;i<100;i++){
            System.out.println(jedisnew.hset("7",i+11+"",i+20+""));
            //System.out.println(jedisnew.hget(i+"",i+11+""));
        }
        System.out.println("~~");
        System.out.println(jedisnew.hget("7","18"));
//        System.out.println(jedisnew.set("key", "value1"));
//        System.out.println(jedisnew.isConnected());
//        CouponDO couponDO=new CouponDO();
//        couponDO.setCouponCode("123455");
//        String str=jedisnew.set(SerializeUtil.serialize("key"), SerializeUtil.serialize(couponDO));
//        System.out.println(str);

    }

    @Test
    public void redisPreOrderTest() {
        //String s = jedis.get("key");
        //System.out.println(s);
        CouponDO couponDO=(CouponDO) SerializeUtil.unserialize(jedisnew.get(SerializeUtil.serialize("key")));
        System.out.println(couponDO);
    }

    @Test
    public void redisPipelineTest() {
        String userOneId = "4352523";
        String userTwoId = "4849888";
        Pipeline p = jedisnew.pipelined();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~1");
        System.out.println(p.sadd("searched#" + userOneId, "paris"));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~1");
        System.out.println(p.zadd("ranking", 126, userOneId));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~1");
        System.out.println(p.zadd("ranking", 325, userTwoId));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~1");
        Response<Boolean> pipeExists = p.sismember("searched#" + userOneId, "paris");
        System.out.println(pipeExists.toString());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~1");
        Response<Set<String>> pipeRanking = p.zrange("ranking", 0, -1);
        System.out.println(pipeRanking.toString());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~1");
        p.sync();
        boolean exists = pipeExists.get();
        System.out.println(exists);
        Set<String> ranking = pipeRanking.get();
        System.out.println(ranking.toArray());
    }

    @After
    public void after() {
        jedisnew.close();
    }
}
