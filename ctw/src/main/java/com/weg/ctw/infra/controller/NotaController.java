package com.weg.ctw.infra.controller;


import com.weg.ctw.dto.requisicao.NotaRequisicao;
import com.weg.ctw.dto.resposta.NotaResposta;
import com.weg.ctw.service.NotaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
@AllArgsConstructor
public class NotaController {

    private final NotaService service;

    @PostMapping
    public ResponseEntity<NotaResposta> lancar(@RequestBody @Valid NotaRequisicao dto) {
        return ResponseEntity.status(201).body(service.lancarNota(dto));
    }

    @GetMapping("/aluno/{idAluno}")
    public ResponseEntity<List<NotaResposta>> listarPorAluno(@PathVariable Integer idAluno) {
        return ResponseEntity.ok(service.listarNotasDoAluno(idAluno));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}