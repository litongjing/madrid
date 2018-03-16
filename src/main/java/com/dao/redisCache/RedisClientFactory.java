package com.dao.redisCache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午6:44 2018/3/13
 */
@Component
@Slf4j
public class RedisClientFactory {

    private static JedisPool jedisPool = null;

    @Resource(name = "redisConfigHolder")
    private RedisConfigHolder holder;


    @PostConstruct
    public void init() {
        JedisPoolConfig jedisPoolConfig = initPoolConfig();
        try {
            jedisPool = new JedisPool(jedisPoolConfig,
                    holder.getHost(),
                    holder.getPort(),
                    holder.getTimeout(),
                    holder.getPassword(),
                    holder.getDatabase()
            );
        } catch (Throwable th) {
            log.error("init JedisPool fail", th);
        }

    }





    @PreDestroy
    public void close() {
        jedisPool.destroy();
    }




    private JedisPoolConfig initPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMaxTotal(50);
        jedisPoolConfig.setMaxWaitMillis(1000L);
        jedisPoolConfig.setTestOnBorrow(true);

        return jedisPoolConfig;
    }

    public static JedisWrapper getJedis() {
        return new JedisWrapper(jedisPool.getResource());
    }
}
