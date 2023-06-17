package com.example.kafka.consumer.kafka;

import com.example.kafka.consumer.data.MessageRepository;
import com.example.kafka.consumer.data.ReceivedMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageConsumer {
    private final MessageRepository messageRepository;

    private Integer counter = 0;

    @KafkaListener(topics = "my_topic", groupId = "1")
    public void receiveMessage(String message) {
        counter++;
        log.info("Received message [%s]".formatted(message));

        var receivedMessage = new ReceivedMessage();
        receivedMessage.setMessage(message);
        receivedMessage.setNumber(counter);

        messageRepository.save(receivedMessage);
    }
}
