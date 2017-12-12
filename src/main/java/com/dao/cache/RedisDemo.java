package com.dao.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午2:30 2017/12/12
 */
@Component
public class RedisDemo {
    @Autowired
    RedisTemplate<String,String> redisTemplate;
    @Autowired
    RedisTemplate<String,Serializable> redisTemplateSerializable;

    public void redisDemo(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }

    public void redisSerializableDemo(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }
}
