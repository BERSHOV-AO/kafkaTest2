package ru.rukafka_kata.kafkatest2.dto;

import lombok.Builder;

@Builder
public record PersonShortDto(String name, String surname, String car) {
}
