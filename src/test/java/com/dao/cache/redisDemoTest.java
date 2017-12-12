package com.dao.cache;

import com.domain.DO.CouponDO;
import com.domain.DTO.CouponDTO;
import com.example.demo.MadridApplication;
import com.manager.CouponManager;
import com.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.concurrent.TimeUnit;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午2:39 2017/12/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
//基本的所有配置都会通过入口类去加载，而注解可以引用入口类的配置
@SpringBootTest(classes = MadridApplication.class)
//@WebAppConfiguration
@Slf4j
public class redisDemoTest {
    @Autowired
    RedisDemo redisDemo;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    CouponManager couponManager;
    @Autowired
    ShardedJedisPool shardedJedisPool;
    @Autowired
    private RedisDataSource redisDataSource;

    @Test
    public void test_redisDemo() {
//        redisTemplate.opsForValue().set("key1", "value");
//        System.out.println(redisTemplate.opsForValue().get("key1"));
        CouponDTO couponDTO = new CouponDTO();
        couponDTO.setCouponCode("5899937701012244");
        CouponDO couponDO = couponManager.selectCoupon(couponDTO);
        redisTemplate.opsForValue().set("coupon3", couponDO);
        System.out.println(redisTemplate.opsForValue().get("coupon3"));
//        redisTemplate.expire("key", 10, TimeUnit.SECONDS);
    }

    @Test
    public void test_ShardedJedisPool() {
        boolean broken = false; //jedis实例是否已不能使用
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();  //从池中获取jedis实例
            log.info("~~~~~~~~~~~~~~");
            shardedJedis.set("key1", "value1");
            String val = shardedJedis.get("key1");
            log.info("~~~~~~~~~~");
            System.out.println(val);
        } catch (Exception e) {
            broken = true;
            e.printStackTrace();
        } finally {
            if (broken) {
                shardedJedisPool.returnBrokenResource(shardedJedis);  //无法正常使用，将jedis实例返回到池中,标识该jedis实例不能使用
            } else {
                shardedJedisPool.returnResource(shardedJedis);  //正常使用完后，将jedis实例返回到池中

            }
        }
    }
    @Test
    public void test_3(){
        CouponDTO couponDTO = new CouponDTO();
        couponDTO.setCouponCode("5899937701012244");
        CouponDO couponDO = couponManager.selectCoupon(couponDTO);
        ShardedJedis shardedJedis=redisDataSource.getRedisClient();
    }
    @Test
    public void test_redislock(){
            RedisLock r=new RedisLock(redisTemplate,"coupon1",1000,1000);
        try {
            r.lock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r.unlock();
    }
    @Test
    public void test_123(){
        System.out.println(DateUtils.format(1513079069559L, "yyyyMMddHHmmss"));
    }
    @Test
    public void tes_124() throws InterruptedException {
        RedisLock r=new RedisLock(redisTemplate,"coupon",1000,1000);
        r.lock();
        r.unlock();
    }
    @Test
    public void test_125(){
        //redisTemplate.delete("coupon1_lock");
        redisTemplate.opsForValue().set("value2","value2");
        //redisTemplate.delete("value2");
    }
}