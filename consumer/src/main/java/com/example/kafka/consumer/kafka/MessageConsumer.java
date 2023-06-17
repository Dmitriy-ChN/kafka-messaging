package com.example.kafka.consumer.kafka;

import com.example.kafka.consumer.data.MessageRepository;
import com.example.kafka.consumer.data.ReceivedMessage;
import com.example.kafka.domain.TextMessage;
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
    public void receiveMessage(TextMessage result) {
        counter++;
        log.info("Received message [%s] from publisher [%s]".formatted(result.message(), result.publisher()));

        var receivedMessage = new ReceivedMessage();
        receivedMessage.setMessage(result.message());
        receivedMessage.setNumber(counter);
        receivedMessage.setPublisher(result.publisher());

        messageRepository.save(receivedMessage);
    }
}
