package com.devjoao.agendamento_transferencia.controller;

import com.devjoao.agendamento_transferencia.domain.Entity.Transferencia;
import com.devjoao.agendamento_transferencia.domain.dto.TransferenciaDTO;
import com.devjoao.agendamento_transferencia.service.TransferenciaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TransferenciaControllerTest {

    @InjectMocks
    TransferenciaController controller;
    @Mock
    TransferenciaService service;

    @Test
    public void test_agendar_with_valid_data_returns_ok() {
        TransferenciaService service = Mockito.mock(TransferenciaService.class);
        TransferenciaController controller = new TransferenciaController();
        ReflectionTestUtils.setField(controller, "service", service);

        TransferenciaDTO dto = new TransferenciaDTO(
                null,
                "123456",
                "654321",
                new BigDecimal("100.00"),
                null,
                LocalDate.now().plusDays(1),
                LocalDate.now()
        );

        Transferencia transferencia = new Transferencia(1L, "123456", "654321", new BigDecimal("100.00"), new BigDecimal("5.00"), LocalDate.now().plusDays(1), LocalDate.now());

        when(service.agendar(dto)).thenReturn(transferencia);

        ResponseEntity<Transferencia> response = controller.agendar(dto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(transferencia, response.getBody());
        verify(service).agendar(dto);

    }

    @Test
    public void test_agendar_with_invalid_data_returns_bad_request() {

        TransferenciaService serviceMock = Mockito.mock(TransferenciaService.class);
        TransferenciaController controller = new TransferenciaController();
        ReflectionTestUtils.setField(controller, "service", serviceMock);

        TransferenciaDTO dto = new TransferenciaDTO(
                null,
                "123456",
                "654321",
                new BigDecimal("-100.00"),
                null,
                LocalDate.now().plusDays(1),
                LocalDate.now()
        );

        Mockito.when(serviceMock.agendar(dto)).thenThrow(new IllegalArgumentException("Valor inválido"));

        ResponseEntity<Transferencia> response = controller.agendar(dto);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
        verify(serviceMock).agendar(dto);
    }
}