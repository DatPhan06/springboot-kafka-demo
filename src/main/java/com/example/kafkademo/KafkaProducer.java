package com.example.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendToTopic1(String message) {
        kafkaTemplate.send("topic1", message);
        System.out.println("Sent to topic1: " + message);
    }

    public void sendToTopic2(String message) {
        kafkaTemplate.send("topic2", message);
        System.out.println("Sent to topic2: " + message);
    }
}