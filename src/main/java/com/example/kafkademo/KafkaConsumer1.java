package com.example.kafkademo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer1 {

    @KafkaListener(topics = "topic1", groupId = "group1")
    public void listenTopic1(String message) {
        System.out.println("Consumer 1 received from topic1: " + message);
    }
}