package com.audit.consumer.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String transactionRef;
    private String instrumentId;
    private String customerId;
    private String tradeType;
    private LocalDateTime createdDateTime;

}
