package com.task;

import com.domain.DTO.CouponDTO;
import com.manager.CouponManager;
import com.mq.activemq.Producer;
import com.util.EnvProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Destination;

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
    @Resource(name = "activemq_producer")
    Producer producer;
    @Resource(name="queueDestination")
    private Destination destination;
    @Test

    public void start(){
              producer.sendMessage(destination,"hello");
//        log.debug("###### current environment is {} ###########", envProperties.getEnv());
//        log.info("###### current environment is {} ###########", envProperties.getEnv());
    }
}
