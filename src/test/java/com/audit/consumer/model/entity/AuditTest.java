package com.audit.consumer.model.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuditTest {

    @Test
    public void testAuditData() {
        Audit audit = new Audit();
        audit.setId(1L);
        audit.setTransactionRef("HCLTRN001");
        audit.setInstrumentId("INST001");
        audit.setCustomerId("CUS001");
        audit.setTradeType("BUY");
        LocalDateTime now = LocalDateTime.now();
        audit.setCreatedDateTime(now);
        assertEquals(1L, audit.getId());
        assertEquals("HCLTRN001", audit.getTransactionRef());
        assertEquals("INST001", audit.getInstrumentId());
        assertEquals("CUS001", audit.getCustomerId());
        assertEquals("BUY", audit.getTradeType());
        assertEquals(now, audit.getCreatedDateTime());
    }

}