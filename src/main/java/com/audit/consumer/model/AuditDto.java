package com.audit.consumer.model;

import com.audit.consumer.model.entity.Audit;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Audit}
 */
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditDto implements Serializable {
    long id;
    String transactionRef;
    String instrumentId;
    String customerId;
    String tradeType;
    LocalDateTime createdDateTime;
}