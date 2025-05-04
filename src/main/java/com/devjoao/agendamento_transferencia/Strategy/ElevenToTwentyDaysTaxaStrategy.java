package com.devjoao.agendamento_transferencia.Strategy;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ElevenToTwentyDaysTaxaStrategy implements TaxaStrategy{
    @Override
    public boolean supports(long dias) {
        return dias >= 11 && dias <= 20;
    }

    @Override
    public BigDecimal calculate(BigDecimal valor) {
        return valor.multiply(new BigDecimal("0.082"));
    }
}
