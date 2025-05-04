package com.devjoao.agendamento_transferencia.exception;

import com.devjoao.agendamento_transferencia.domain.dto.ResponseErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseErrorDTO> handleIllegalArgumentException(IllegalArgumentException ex) {
        ResponseErrorDTO error = new ResponseErrorDTO();
        error.setError(ex.getMessage());
        error.setMessage("Não há taxa aplicável para essa data");
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
