package com.example.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final String topic = "test_topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void produceMessage(String message) {
        this.kafkaTemplate.send(topic, message);
    }
}
