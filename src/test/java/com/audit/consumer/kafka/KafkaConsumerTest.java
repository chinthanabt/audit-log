package com.audit.consumer.kafka;


import com.audit.consumer.mapper.AuditMapper;
import com.audit.consumer.model.AuditDto;
import com.audit.consumer.model.entity.Audit;
import com.audit.consumer.service.KafkaAuditService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class KafkaConsumerTest {

    @Mock
    private KafkaAuditService auditService;

    @Mock
    private AuditMapper auditMapper;

    private KafkaConsumer kafkaConsumer;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        kafkaConsumer = new KafkaConsumer(auditService, auditMapper);
    }

    @Test
    public void testValidMessage() throws Exception {
        String validJsonMessage = "{\"id\":1,\"transactionRef\":\"TXN123456\",\"instrumentId\":\"INST0001\",\"customerId\":\"CUST0001\",\"tradeType\":\"BUY\",\"createdDateTime\":\"2024-04-27T12:00:00\"}";
        Audit auditEntity = new Audit();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        when(auditMapper.dtoToEntityMapper(any(AuditDto.class))).thenReturn(auditEntity);

        kafkaConsumer.listen(validJsonMessage);

        verify(auditMapper).dtoToEntityMapper(any(AuditDto.class));
        verify(auditService).save(auditEntity);
    }

    @Test
    public void testInvalidJsonMessage() throws Exception {
        String invalidJsonMessage = "invalid json";

        kafkaConsumer.listen(invalidJsonMessage);

        verify(auditMapper, never()).dtoToEntityMapper(any(AuditDto.class));
        verify(auditService, never()).save(any(Audit.class));
    }

    @Test
    public void testExceptionDuringProcessing() throws Exception {
        String validJsonMessage = "{\"id\":1,\"transactionRef\":\"TXN123456\",\"instrumentId\":\"INST0001\",\"customerId\":\"CUST0001\",\"tradeType\":\"BUY\",\"createdDateTime\":\"2024-04-27T12:00:00\"}";
        AuditDto auditDto = new AuditDto(); // Populate as needed

        when(auditMapper.dtoToEntityMapper(any(AuditDto.class))).thenThrow(new RuntimeException("Test exception"));

        kafkaConsumer.listen(validJsonMessage);

        verify(auditService, never()).save(any(Audit.class));
    }

}
