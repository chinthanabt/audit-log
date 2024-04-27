package com.audit.consumer.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AuditDtoTest {

@Test
    void dtoTestData(){

        AuditDto dto = new AuditDto();
        dto.setId(1);
        dto.setTransactionRef("HCLTRN001");
        dto.setCustomerId("CUS001");
        dto.setTradeType("Buy");
        dto.setInstrumentId("INS001");
        LocalDateTime now = LocalDateTime.now();
        dto.setCreatedDateTime(now);
        assertEquals(1L, dto.getId());
        assertEquals("HCLTRN001", dto.getTransactionRef());
        assertEquals("CUS001", dto.getCustomerId());
        assertEquals("Buy", dto.getTradeType());
        assertEquals("INS001", dto.getInstrumentId());
        assertEquals(now, dto.getCreatedDateTime());
    }
}
