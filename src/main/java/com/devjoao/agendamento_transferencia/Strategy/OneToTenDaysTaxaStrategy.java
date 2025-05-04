package com.devjoao.agendamento_transferencia.Strategy;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OneToTenDaysTaxaStrategy implements TaxaStrategy {
    @Override
    public boolean supports(long dias) {
        return dias >= 1 && dias <= 10;
    }

    @Override
    public BigDecimal calculate(BigDecimal valor) {
        return new BigDecimal("12.00")
                .add(valor.multiply(new BigDecimal("0.0")));
    }
}
