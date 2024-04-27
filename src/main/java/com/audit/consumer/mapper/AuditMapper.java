package com.audit.consumer.mapper;

import com.audit.consumer.model.AuditDto;
import com.audit.consumer.model.entity.Audit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuditMapper {

AuditMapper INSTANCE = Mappers.getMapper(AuditMapper.class);

AuditDto entityToDtoMapper(Audit audit);

Audit dtoToEntityMapper(AuditDto dto);
}
