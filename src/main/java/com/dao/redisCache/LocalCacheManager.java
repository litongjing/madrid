package com.dao.redisCache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午6:43 2018/3/13
 */
public class LocalCacheManager {
    public static LoadingCache<String, Optional<String>> CARD_ORDER_PAY_CACHE = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterAccess(24, TimeUnit.HOURS)
            .build(
                    new CacheLoader<String, Optional<String>>() {
                        public Optional<String> load(String orderNo) throws Exception {
                            return Optional.empty();
                        }
                    });

}
