package ru.rukafka_kata.kafkatest2.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    @KafkaListener(topics = "${kafka.consumer.topic.send-message-topic}")
    public void read(String message) {
        System.out.println(message);
    }
}
