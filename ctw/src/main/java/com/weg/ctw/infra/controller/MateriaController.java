package com.weg.ctw.infra.controller;


import com.weg.ctw.dto.requisicao.MateriaRequisicao;
import com.weg.ctw.dto.resposta.MateriaResposta;
import com.weg.ctw.service.MateriaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materias")
@AllArgsConstructor
public class MateriaController {

    private final MateriaService service;

    @PostMapping
    public ResponseEntity<MateriaResposta> salvar(@RequestBody @Valid MateriaRequisicao dto) {
        return ResponseEntity.status(201).body(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<MateriaResposta>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaResposta> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(
                com.weg.ctw.mapper.MateriaMapper.paraResposta(service.buscarPorId(id))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}