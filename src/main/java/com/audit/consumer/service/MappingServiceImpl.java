package com.audit.consumer.service;

import com.audit.consumer.mapper.AuditMapper;
import com.audit.consumer.model.AuditDto;
import com.audit.consumer.model.entity.Audit;
import org.springframework.stereotype.Service;

@Service
public class MappingServiceImpl implements MappingService {


    @Override
    public Audit dtoToAuditEntity(AuditDto dto) {
        return AuditMapper.INSTANCE.dtoToEntityMapper(dto);
    }

    @Override
    public AuditDto auditEntityToDto(Audit audit) {
        return AuditMapper.INSTANCE.entityToDtoMapper(audit);
    }
}
