package com.weg.ctw.infra.controller;

import com.weg.ctw.dto.requisicao.ProfessorRequisicao;
import com.weg.ctw.dto.resposta.ProfessorResposta;
import com.weg.ctw.service.ProfessorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
@AllArgsConstructor
public class ProfessorController {

    private final ProfessorService service;

    @PostMapping
    public ResponseEntity<ProfessorResposta> salvar(@RequestBody @Valid ProfessorRequisicao dto) {
        return ResponseEntity.status(201).body(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResposta>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResposta> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(
                com.weg.ctw.mapper.ProfessorMapper.paraResposta(service.buscarPorId(id))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}