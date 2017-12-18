package com.task;

import com.domain.DTO.CouponDTO;
import com.manager.CouponManager;
import com.util.EnvProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午1:51 2017/12/14
 */
@Component("healthy_task")
@Slf4j
public class HealthyTask {
    @Autowired
    EnvProperties envProperties;
    @Autowired
    CouponManager couponManager;

    public void start(){
        log.debug("###### current environment is {} ###########", envProperties.getEnv());
        log.info("###### current environment is {} ###########", envProperties.getEnv());
    }
}
