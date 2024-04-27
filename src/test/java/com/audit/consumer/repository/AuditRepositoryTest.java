package com.audit.consumer.repository;

import com.audit.consumer.model.entity.Audit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AuditRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AuditRepository auditRepository;

    @Test
    public void testSaveAudit() {
        // Create a new Audit instance
        Audit audit = new Audit();
        audit.setTransactionRef("REF1001");
        audit.setInstrumentId("INST001");
        audit.setCustomerId("CUST001");
        audit.setTradeType("Buy");
        audit.setCreatedDateTime(LocalDateTime.now());

        // Persist the audit instance using AuditRepository
        Audit savedAudit = auditRepository.save(audit);

        // Validate that the audit has been saved correctly
        assertNotNull(savedAudit.getId());
        assertEquals("REF1001", savedAudit.getTransactionRef());

        // Optionally, fetch the entity back from the database to verify it's saved correctly
        Audit fetchedAudit = auditRepository.findById(savedAudit.getId()).orElse(null);
        assertNotNull(fetchedAudit);
        assertEquals("CUST001", fetchedAudit.getCustomerId());
    }

}

