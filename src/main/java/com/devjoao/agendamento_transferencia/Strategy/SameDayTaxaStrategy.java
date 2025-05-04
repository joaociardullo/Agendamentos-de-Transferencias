package com.devjoao.agendamento_transferencia.Strategy;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SameDayTaxaStrategy implements TaxaStrategy {
    @Override
    public boolean supports(long dias) {
        return dias == 0;
    }

    @Override
    public BigDecimal calculate(BigDecimal valor) {
        return new BigDecimal("3.00")
                .add(valor.multiply(new BigDecimal("0.025")));
    }
}
