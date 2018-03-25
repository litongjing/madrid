package com.mq.activemq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午2:52 2017/12/25
 */
@Service("activemq_producer")
@Slf4j
public class Producer {
    @Resource
    private JmsTemplate jmsTemplate;

    public void sendMessage(Destination destination, final String message) {
        log.info("~~~~~~~~~~~~~~~~~~~~~~~");
        log.info("开始发送消息：{}",message);
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }
}
