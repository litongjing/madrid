package com.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午9:53 2017/12/7
 */
public class EnvProperties {
    private  String env;

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }
}