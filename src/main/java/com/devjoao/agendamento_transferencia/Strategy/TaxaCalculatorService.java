package com.devjoao.agendamento_transferencia.Strategy;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TaxaCalculatorService {

    private final List<TaxaStrategy> strategies;

    public TaxaCalculatorService(List<TaxaStrategy> strategies) {
        this.strategies = strategies;
    }

    public BigDecimal calculate(long dias, BigDecimal valor) {
        return strategies.stream()
                .filter(s -> s.supports(dias))
                .findFirst()
                .map(s -> s.calculate(valor))
                .orElseThrow(() -> new IllegalArgumentException(
                        "Não há taxa aplicável para agendamento com " + dias + " dias de antecedência"));
    }
}
