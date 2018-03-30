package com.dao.mq;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import com.example.demo.MadridApplication;
import com.mq.activemq.Producer;
import com.mq.kafka.KafkaProducerServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
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

    @Autowired
    DefaultMQProducer defaultMQProducer;

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
    public void test_kafka() throws InterruptedException {
        String topic = "test1";
        String value = "ltj test";
        String ifPartition = "0";
        Integer partitionNum = 1;
        String role = "test";//用来生成key
        for (int i = 0; i < 1; i++) {
            Map<String, Object> res = kafkaProducerServer.sendMessageForTemplate
                    (topic, value, ifPartition, partitionNum, role);
            String message = (String) res.get("message");
            String code = (String) res.get("code");
            log.info("code:{}", code);
            log.info("message:{}", message);
        }
        log.info("测试结果如下：===============");

        Thread.sleep(10000);
    }

    @Test
    public void test_123() throws InterruptedException {
        Thread.sleep(10000);
    }

    @Test
    public void rocketMq_test() {
        try {
            Message msg = new Message("PushTopic", "push", "rocketmq for test.123412414".getBytes());
            SendResult result = defaultMQProducer.send(msg);
            System.out.println("id:" + result.getMsgId() + " result:" + result.getSendStatus());
        } catch (BeansException e) {
            e.printStackTrace();
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
