package com.example.kafkademo;

import com.example.kafkademo.model.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer2 {

    @KafkaListener(topics = "topic2", groupId = "group1")
    public void listen(Message message) {
        System.out.println("Consumer2 received message: " + message);
        // Process the message and send response if needed
        if (message.getType() == Message.MessageType.REQUEST) {
            Message response = new Message();
            response.setContent("Response from Consumer2 to: " + message.getContent());
            response.setSender("Consumer2");
            response.setType(Message.MessageType.RESPONSE);
            // You can send response back to another topic if needed
        }
    }
}