package com.audit.consumer.service;

import com.audit.consumer.model.entity.Audit;
import com.audit.consumer.repository.AuditRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KafkaAuditServiceImpl implements KafkaAuditService{

    private AuditRepository repository;

    public KafkaAuditServiceImpl(AuditRepository auditRepository) {
        this.repository = auditRepository;
    }

    @Override
    public Audit save(Audit audit) throws DataAccessException {
        return repository.save(audit);
    }
}
