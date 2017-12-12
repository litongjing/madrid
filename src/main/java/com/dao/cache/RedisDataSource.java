package com.dao.cache;

import redis.clients.jedis.ShardedJedis;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午5:17 2017/12/12
 */
public interface RedisDataSource {
    public abstract ShardedJedis getRedisClient();
    public void returnResource(ShardedJedis shardedJedis);
    public void returnResource(ShardedJedis shardedJedis,boolean broken);
}
