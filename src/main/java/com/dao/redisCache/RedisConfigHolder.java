package com.dao.redisCache;

import lombok.Data;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午6:46 2018/3/13
 */
@Data
public class RedisConfigHolder {
    private String host;
    private String password;
    private int timeout;
    private int port;
    private int database;
}
