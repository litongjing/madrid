package com.dao.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午5:18 2017/12/12
 */
@Repository("redisDataSource")
@Slf4j
public class RedisResourceImpl implements RedisDataSource {
    @Autowired
    private ShardedJedisPool shardedJedisPool;

    @Override
    public ShardedJedis getRedisClient() {
        try {
            ShardedJedis shardedJedis = shardedJedisPool.getResource();
            return shardedJedis;
        } catch (Exception e) {
            log.error("getRedisClent error {}", e.toString());
        }
        return null;
    }

    @Override
    public void returnResource(ShardedJedis shardedJedis) {
        //已deprecated
        shardedJedisPool.returnResource(shardedJedis);
        //最新
        //shardedJedis.close();
    }

    @Override
    public void returnResource(ShardedJedis shardedJedis, boolean broken) {
        //deprecated
        if (broken) {
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } else {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }
}
