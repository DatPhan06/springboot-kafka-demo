package com.example.kafkademo2;

import com.example.kafkademo2.model.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer2 {

    @KafkaListener(topics = "topic1", groupId = "group2")
    public void listenTopic1(Message message) {
        System.out.println("App2 Consumer received from topic1: " + message);
        if (message.getType() == Message.MessageType.REQUEST) {
            Message response = new Message();
            response.setContent("Response from App2 Consumer to: " + message.getContent());
            response.setSender("App2Consumer");
            response.setType(Message.MessageType.RESPONSE);
        }
    }

    @KafkaListener(topics = "topic2", groupId = "group2")
    public void listenTopic2(Message message) {
        System.out.println("App2 Consumer received from topic2: " + message);
        if (message.getType() == Message.MessageType.REQUEST) {
            Message response = new Message();
            response.setContent("Response from App2 Consumer to: " + message.getContent());
            response.setSender("App2Consumer");
            response.setType(Message.MessageType.RESPONSE);
        }
    }
} 