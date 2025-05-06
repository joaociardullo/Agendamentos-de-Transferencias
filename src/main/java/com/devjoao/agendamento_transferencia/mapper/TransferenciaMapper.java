package com.devjoao.agendamento_transferencia.mapper;

import com.devjoao.agendamento_transferencia.domain.Entity.Transferencia;
import com.devjoao.agendamento_transferencia.domain.dto.TransferenciaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransferenciaMapper {
    Transferencia toEntity(TransferenciaDTO dto);

    TransferenciaDTO toDomain(Transferencia entity);
}
