package ru.rukafka_kata.kafkatest2.service;

import ru.rukafka_kata.kafkatest2.dto.PersonDto;

public interface KafkaProducerService {

    void sendShortPersonDto(PersonDto personDto);
}
