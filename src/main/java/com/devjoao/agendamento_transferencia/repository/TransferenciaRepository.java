package com.devjoao.agendamento_transferencia.repository;

import com.devjoao.agendamento_transferencia.domain.Entity.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    @Query("SELECT t FROM Transferencia t WHERE t.contaOrigem = :contaOrigem")
    ArrayList<Transferencia> findByContaOrigem(String contaOrigem);
}
