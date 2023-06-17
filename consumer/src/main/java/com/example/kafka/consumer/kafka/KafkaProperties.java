package com.example.kafka.consumer.kafka;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("kafka")
public record KafkaProperties(String address, String topics, String groupId) {
}
