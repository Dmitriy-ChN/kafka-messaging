package com.example.kafka.publisher.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessagePublisher {
    private final KafkaProperties properties;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        var future = kafkaTemplate.send(properties.topics(), message);

        future.whenComplete((result, exception) -> {
            if (exception == null) {
                log.info("Sent message [%s] with offset [%s]".formatted(message, result.getRecordMetadata().offset()));
            } else {
                log.error("Unable to send [%s]".formatted(message), exception);
            }
        });
    }
}
