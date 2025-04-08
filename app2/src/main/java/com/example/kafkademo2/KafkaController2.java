package com.example.kafkademo2;

import com.example.kafkademo2.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class KafkaController2 {

    @Autowired
    private KafkaProducer2 kafkaProducer;

    @PostMapping("/send/topic1")
    public ResponseEntity<Message> sendToTopic1(@RequestBody Message message) {
        message.setSender("App2");
        message.setType(Message.MessageType.REQUEST);
        kafkaProducer.sendToTopic1(message)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        System.out.println("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
                    } else {
                        System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
                    }
                });
        return ResponseEntity.ok(message);
    }

    @PostMapping("/send/topic2")
    public ResponseEntity<Message> sendToTopic2(@RequestBody Message message) {
        message.setSender("App2");
        message.setType(Message.MessageType.REQUEST);
        kafkaProducer.sendToTopic2(message)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        System.out.println("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
                    } else {
                        System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
                    }
                });
        return ResponseEntity.ok(message);
    }
} 