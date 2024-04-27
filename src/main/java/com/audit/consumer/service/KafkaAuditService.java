package com.audit.consumer.service;

import com.audit.consumer.model.entity.Audit;
import org.springframework.dao.DataAccessException;


public interface KafkaAuditService {

    public Audit save(Audit audit) throws DataAccessException;
}
