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
public class ConsumeMessageListener implements MessageListener {
    int i=0;
    @Override
    public void onMessage(Message message) {
        TextMessage textMsg = (TextMessage) message;
        try {
            log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            log.info("队列接收者受到消息：{}",textMsg.getText());
            i=i+1;
        } catch (JMSException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }
}
