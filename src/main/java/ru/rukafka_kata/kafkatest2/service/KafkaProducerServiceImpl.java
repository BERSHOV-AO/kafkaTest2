package ru.rukafka_kata.kafkatest2.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.rukafka_kata.kafkatest2.dto.PersonDto;
import ru.rukafka_kata.kafkatest2.dto.PersonShortDto;

@Service
@RequiredArgsConstructor
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value("${kafka.producer.topic.send-message-topic}")
    private String topicName;

    @Override
    @SneakyThrows
    public void sendShortPersonDto(PersonDto personDto) {

        PersonShortDto personShortDto = PersonShortDto.builder().
                name(personDto.name()).
                surname(personDto.surname()).
                car(personDto.car()).build();

        String strPersonShortDto = objectMapper.writeValueAsString(personShortDto);
        kafkaTemplate.send(topicName, strPersonShortDto);
    }
}
