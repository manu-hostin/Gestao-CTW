package com.weg.ctw.infra.controller;

import com.weg.ctw.dto.requisicao.AlunoRequisicao;
import com.weg.ctw.dto.resposta.AlunoResposta;
import com.weg.ctw.service.AlunoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@AllArgsConstructor
public class AlunoController {

    private final AlunoService service;

    @PostMapping
    public ResponseEntity<AlunoResposta> salvar(@RequestBody @Valid AlunoRequisicao dto) {
        return ResponseEntity.status(201).body(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<AlunoResposta>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResposta> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(
                com.weg.ctw.mapper.AlunoMapper.paraResposta(service.buscarPorId(id))
        );
    }
}
