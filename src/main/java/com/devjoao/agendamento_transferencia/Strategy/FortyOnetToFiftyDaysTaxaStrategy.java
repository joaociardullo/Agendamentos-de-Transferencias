package com.devjoao.agendamento_transferencia.Strategy;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class FortyOnetToFiftyDaysTaxaStrategy implements TaxaStrategy{
    @Override
    public boolean supports(long dias) {
        return dias >= 41 && dias <= 50;
    }

    @Override
    public BigDecimal calculate(BigDecimal valor) {
        return valor.multiply(new BigDecimal("0.017"));
    }
}
