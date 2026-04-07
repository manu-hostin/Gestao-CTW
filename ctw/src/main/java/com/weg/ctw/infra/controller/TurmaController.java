package com.weg.ctw.infra.controller;

import com.weg.ctw.dto.requisicao.TurmaRequisicao;
import com.weg.ctw.dto.resposta.TurmaResposta;
import com.weg.ctw.service.TurmaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
@AllArgsConstructor
public class TurmaController {

    private final TurmaService service;

    @PostMapping
    public ResponseEntity<TurmaResposta> salvar(@RequestBody @Valid TurmaRequisicao dto) {
        return ResponseEntity.status(201).body(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<TurmaResposta>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaResposta> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(
                com.weg.ctw.mapper.TurmaMapper.paraResposta(service.buscarPorId(id))
        );
    }
}