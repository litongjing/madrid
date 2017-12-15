package com.controller;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 上午10:51 2017/12/9
 */
@RestController
@Slf4j
public class demoController {
    @PostMapping("/queryname")
    public String queryProjectName(@RequestBody String param) {
        log.info("queryname:{}", param);
        return param;
    }

    @RequestMapping("/sleep")
    public String sleep() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
                log.info("~~~sleepting {}", i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "success";
    }

    //applicaton/x-www-form-urlencoded
    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam String name, @RequestParam String password) {
        Map<String, Object> resultMap = Maps.newHashMap();
        resultMap.put("name", name);
        resultMap.put("password", password);
        return resultMap;
    }
}
