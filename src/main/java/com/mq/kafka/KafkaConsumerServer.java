package com.mq.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 上午11:56 2017/12/26
 */
@Slf4j
public class KafkaConsumerServer implements MessageListener<String, String> {
    @Override
    public void onMessage(ConsumerRecord<String, String> record) {
        log.info("===============kafka开始消费================");
        String topic = record.topic();
        String key = record.key();
        String value = record.value();
        log.info("~~~~~~~~~~~~~");
        log.info(record.value());
        long offset = record.offset();
        int partition = record.partition();
        log.info("topic:{}", topic);
        log.info("key:{}", key);
        log.info("value:{}", value);
        log.info("offset:{}", offset);
        log.info("partition:{}", partition);
        log.info("===============kafka结束消费================");
    }
}
