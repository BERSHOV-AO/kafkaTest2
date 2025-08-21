package ru.rukafka_kata.kafkatest2.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.rukafka_kata.kafkatest2.dto.PersonDto;
import ru.rukafka_kata.kafkatest2.service.KafkaProducerService;

@RequiredArgsConstructor
@Component
public class MessageListener {

    private final ObjectMapper objectMapper;

    private final KafkaProducerService kafkaProducerService;

    @SneakyThrows
    @KafkaListener(topics = "${kafka.consumer.topic.send-message-topic}")
    public void read(String message) {

        PersonDto personDto = objectMapper.readValue(message, PersonDto.class);
        System.out.println("Person input dto: " + personDto.toString());
        kafkaProducerService.sendShortPersonDto(personDto);
    }
}
