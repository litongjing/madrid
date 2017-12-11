package com.util;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午7:18 2017/12/8
 */
public class Env {
    @Autowired
    EnvProperties envProperties;
    public String getEnv(){
        return envProperties.getEnv();
    }
}
