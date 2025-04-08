package com.example.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/send/topic1")
    public String sendToTopic1(@RequestParam("message") String message) {
        kafkaProducer.sendToTopic1(message);
        return "Message sent to topic1: " + message;
    }

    @PostMapping("/send/topic2")
    public String sendToTopic2(@RequestParam("message") String message) {
        kafkaProducer.sendToTopic2(message);
        return "Message sent to topic2: " + message;
    }
}