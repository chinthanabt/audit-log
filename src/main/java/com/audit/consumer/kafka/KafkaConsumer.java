package com.audit.consumer.kafka;

import com.audit.consumer.mapper.AuditMapper;
import com.audit.consumer.model.AuditDto;
import com.audit.consumer.service.KafkaAuditService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    private AuditMapper auditMapper;
    private KafkaAuditService auditService;
    public KafkaConsumer(KafkaAuditService service,AuditMapper mapper){
        this.auditService=service;
        this.auditMapper=mapper;
    }

    @KafkaListener(topics = "hcl-audit-topic", groupId = "hcl-group")
    public void listen(String message) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try{
            AuditDto auditDto = mapper.readValue(message, AuditDto.class);
           auditService.save(auditMapper.dtoToEntityMapper(auditDto));
           log.info(auditDto.toString());
        }catch (JsonProcessingException e){
         log.error("Unable to map to as JSON Source: "+ message);
         //Send the message to DEAD LETTER QUEUE
        }catch (Exception e){
            log.error(e.getLocalizedMessage());
            //send the message to DEAD LETTER QUEUE
        }
    }
}
