package com.audit.consumer.service;

import com.audit.consumer.model.AuditDto;
import com.audit.consumer.model.entity.Audit;

public interface MappingService {

    Audit dtoToAuditEntity(AuditDto dto);

    AuditDto auditEntityToDto(Audit audit);
}
