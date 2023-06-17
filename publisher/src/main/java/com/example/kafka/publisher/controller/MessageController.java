package com.example.kafka.publisher.controller;

import com.example.kafka.publisher.kafka.MessagePublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {
    private final MessagePublisher messagePublisher;

    @GetMapping("/{text}")
    public void sendMessage(@PathVariable String text) {
        messagePublisher.sendMessage(text);
    }
}
