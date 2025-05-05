package com.devjoao.agendamento_transferencia.service;

import com.devjoao.agendamento_transferencia.domain.Entity.Transferencia;
import com.devjoao.agendamento_transferencia.domain.dto.TransferenciaDTO;

import java.util.List;

public interface TransferenciaService {

    Transferencia agendar(TransferenciaDTO transferenciaDTO);

    List<Transferencia> listarTodas();

    void deletar(Long id);
}
