package com.audit.consumer.mapper;

import com.audit.consumer.model.AuditDto;

import com.audit.consumer.model.entity.Audit;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.time.LocalDateTime;


class AuditMapperTest {
    @Mock
    private AuditMapper aapper;

    private final AuditMapper mapper = AuditMapper.INSTANCE;

    @Test
    public void testEntityToDtoMapping() {
        Audit audit = new Audit();
        audit.setId(1);
        audit.setTransactionRef("HCLTRN001");
        audit.setInstrumentId("INS_1");
        audit.setCustomerId("CUS001");
        audit.setTradeType("Buy");
        audit.setCreatedDateTime(LocalDateTime.now());

        AuditDto dto = mapper.entityToDtoMapper(audit);

        assertEquals(audit.getId(), dto.getId());
        assertEquals(audit.getTransactionRef(), dto.getTransactionRef());
        assertEquals(audit.getInstrumentId(), dto.getInstrumentId());
        assertEquals(audit.getCustomerId(), dto.getCustomerId());
        assertEquals(audit.getTradeType(), dto.getTradeType());
        assertEquals(audit.getCreatedDateTime(), dto.getCreatedDateTime());
    }

    @Test
    void testDtoToEntityMapping() {
        AuditDto dto = new AuditDto();
        dto.setId(1);
        dto.setTransactionRef("HCLTRN001");
        dto.setInstrumentId("INST_01");
        dto.setCustomerId("CUS001");
        dto.setTradeType("Sell");
        dto.setCreatedDateTime(LocalDateTime.now());

        Audit audit = mapper.dtoToEntityMapper(dto);

        assertEquals(dto.getId(), audit.getId());
        assertEquals(dto.getTransactionRef(), audit.getTransactionRef());
        assertEquals(dto.getInstrumentId(), audit.getInstrumentId());
        assertEquals(dto.getCustomerId(), audit.getCustomerId());
        assertEquals(dto.getTradeType(), audit.getTradeType());
        assertEquals(dto.getCreatedDateTime(), audit.getCreatedDateTime());
    }



}

