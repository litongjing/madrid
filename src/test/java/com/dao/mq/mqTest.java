package com.dao.mq;

import com.example.demo.MadridApplication;
import com.mq.activemq.Producer;
import com.mq.kafka.KafkaProducerServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.jms.Destination;
import java.util.Map;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午2:59 2017/12/25
 */
@RunWith(SpringJUnit4ClassRunner.class)
//基本的所有配置都会通过入口类去加载，而注解可以引用入口类的配置
@SpringBootTest(classes = MadridApplication.class)
//@WebAppConfiguration
@Slf4j
public class mqTest {
    @Resource(name = "activemq_producer")
    Producer producer;
    @Resource(name = "queueDestination")
    private Destination destination;
    @Resource(name = "topicDestination")
    private Destination topicDestination;
    @Autowired
    KafkaProducerServer kafkaProducerServer;

    @Test
    public void test_produce() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            producer.sendMessage(destination, "hello" + i);
        }
        Thread.sleep(10000);
    }

    @Test
    public void test_topicProduce() {
        producer.sendMessage(topicDestination, "hello topic");
    }

    @Test
    public void test_kafka() {
//        KafkaProducerServer kafkaProducer = new KafkaProducerServer();
        String topic = "xxTopic";
        String value = "不容易啊";
        String ifPartition = "0";
        Integer partitionNum = 1;
        String role = "test";//用来生成key
        Map<String, Object> res = kafkaProducerServer.sendMessageForTemplate
                (topic, value, ifPartition, partitionNum, role);

        log.info("测试结果如下：===============");
        String message = (String) res.get("message");
        String code = (String) res.get("code");

        log.info("code:{}", code);
        log.info("message:{}", message);
    }
}
