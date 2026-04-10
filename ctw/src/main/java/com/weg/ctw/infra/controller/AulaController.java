package com.weg.ctw.infra.controller;


import com.weg.ctw.dto.requisicao.AulaRequisicao;
import com.weg.ctw.dto.resposta.AulaResposta;
import com.weg.ctw.service.AulaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestControllera
@RequestMapping("/aulas")
@AllArgsConstructor
public class AulaController {

    private final AulaService service;

    @PostMapping
    public ResponseEntity<AulaResposta> agendar(@RequestBody @Valid AulaRequisicao dto) {
        return ResponseEntity.status(201).body(service.agendar(dto));
    }

    @GetMapping
    public ResponseEntity<List<AulaResposta>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
