package com.mq.activemq;

import lombok.extern.slf4j.Slf4j;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午2:56 2017/12/25
 */
@Slf4j
public class TopicConsumeMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        TextMessage textMsg = (TextMessage) message;
        try {
            log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            log.info("订阅接收者收到消息：{}",textMsg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
