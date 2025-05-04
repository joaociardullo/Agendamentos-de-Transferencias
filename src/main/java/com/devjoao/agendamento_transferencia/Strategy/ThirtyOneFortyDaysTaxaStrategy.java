package com.devjoao.agendamento_transferencia.Strategy;

import java.math.BigDecimal;

public class ThirtyOneFortyDaysTaxaStrategy implements TaxaStrategy {
    @Override
    public boolean supports(long dias) {
        return dias >= 31 && dias <= 40;
    }

    @Override
    public BigDecimal calculate(BigDecimal valor) {
        return new BigDecimal("0.00")
                .add(valor.multiply(new BigDecimal("0.047")));
    }
}
