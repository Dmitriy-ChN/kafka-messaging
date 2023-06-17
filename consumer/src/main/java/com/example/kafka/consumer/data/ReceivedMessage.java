package com.example.kafka.consumer.data;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "ReceivedMessage")
@Data
public class ReceivedMessage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String message;
    private Integer number;
    private String publisher;
}
