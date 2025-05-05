package com.devjoao.agendamento_transferencia.controller;

import com.devjoao.agendamento_transferencia.domain.Entity.Transferencia;
import com.devjoao.agendamento_transferencia.domain.dto.TransferenciaDTO;
import com.devjoao.agendamento_transferencia.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    @Autowired
    private TransferenciaService service;

    @PostMapping
    public ResponseEntity<Transferencia> agendar(@RequestBody @Validated TransferenciaDTO transferencia) {
        try {
            return ResponseEntity.ok(service.agendar(transferencia));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Transferencia>> listar() {
        List<Transferencia> transferencias = service.listarTodas();
        return new ResponseEntity<>(transferencias, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
