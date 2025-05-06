package com.devjoao.agendamento_transferencia.service.impl;

import com.devjoao.agendamento_transferencia.Strategy.TaxaCalculatorService;
import com.devjoao.agendamento_transferencia.domain.Entity.Transferencia;
import com.devjoao.agendamento_transferencia.domain.dto.TransferenciaDTO;
import com.devjoao.agendamento_transferencia.mapper.TransferenciaMapper;
import com.devjoao.agendamento_transferencia.repository.TransferenciaRepository;
import com.devjoao.agendamento_transferencia.service.TransferenciaService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {

    private final TransferenciaRepository repository;
    private final TransferenciaMapper mapper;
    private final TaxaCalculatorService taxaCalculator;

    public TransferenciaServiceImpl(TransferenciaRepository repository, TransferenciaMapper mapper, TaxaCalculatorService taxaCalculator) {
        this.repository = repository;
        this.mapper = mapper;
        this.taxaCalculator = taxaCalculator;
    }

    public Transferencia agendar(TransferenciaDTO transferenciaDTO) {
        var dias = ChronoUnit.DAYS.between(LocalDate.now(), transferenciaDTO.getDataTransferencia());

        BigDecimal taxa = taxaCalculator.calculate(dias, transferenciaDTO.getValor());
        transferenciaDTO.setTaxa(taxa);
        transferenciaDTO.setDataAgendamento(LocalDate.now());
        Transferencia entity = mapper.toEntity(transferenciaDTO);
        return repository.save(entity);
    }

    public List<Transferencia> listarTodas() {
        return repository.findAll();
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Transferência não encontrada");
        }
        repository.deleteById(id);
    }

    @Override
    public List<Transferencia> listarPorContaOrigem(String contaOrigem) {
        return repository.findByContaOrigem(contaOrigem);
    }
}