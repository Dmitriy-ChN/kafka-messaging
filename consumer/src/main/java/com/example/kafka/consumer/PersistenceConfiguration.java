package com.example.kafka.consumer;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.example.kafka.consumer.data")
@EntityScan("com.example.kafka.consumer.data")
public class PersistenceConfiguration {
}
