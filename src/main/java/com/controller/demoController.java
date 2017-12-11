package com.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 上午10:51 2017/12/9
 */
@RestController
public class demoController {

    @PostMapping("/queryname")
    public String queryProjectName(@RequestBody String param) {
        return param;
    }
}
