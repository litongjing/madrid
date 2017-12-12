package com.dao;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午5:46 2017/12/12
 */
public class JedisTest {
    private Jedis jedis;
    @Before
    public void setup(){
        jedis = new Jedis("192.168.130.7", 6379);
        jedis.auth("intimednb");
    }
}
