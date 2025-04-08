package com.example.kafkademo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer2 {

    @KafkaListener(topics = "topic2", groupId = "group1")
    public void listenTopic2(String message) {
        System.out.println("Consumer 2 received from topic2: " + message);
    }
}