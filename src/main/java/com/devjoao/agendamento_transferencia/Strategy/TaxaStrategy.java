package com.devjoao.agendamento_transferencia.Strategy;

import java.math.BigDecimal;

public interface TaxaStrategy {
    boolean supports(long dias);

    BigDecimal calculate(BigDecimal valor);
}