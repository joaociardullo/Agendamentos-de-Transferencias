package com.devjoao.agendamento_transferencia.repository;

import com.devjoao.agendamento_transferencia.domain.Entity.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

}
