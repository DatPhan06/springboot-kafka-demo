package com.example.kafkademo2;

import com.example.kafkademo2.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Component
public class KafkaProducer2 {

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    public CompletableFuture<SendResult<String, Message>> sendToTopic1(Message message) {
        message.setId(UUID.randomUUID().toString());
        message.setTimestamp(java.time.LocalDateTime.now());
        return kafkaTemplate.send("topic1", message);
    }

    public CompletableFuture<SendResult<String, Message>> sendToTopic2(Message message) {
        message.setId(UUID.randomUUID().toString());
        message.setTimestamp(java.time.LocalDateTime.now());
        return kafkaTemplate.send("topic2", message);
    }
} 