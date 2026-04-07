package com.weg.ctw.infra.controller;


import com.weg.ctw.dto.requisicao.SalaRequisicao;
import com.weg.ctw.dto.resposta.SalaResposta;
import com.weg.ctw.mapper.SalaMapper;
import com.weg.ctw.service.SalaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
@AllArgsConstructor
public class SalaController {

    private final SalaService service;

    @PostMapping
    public ResponseEntity<SalaResposta> salvar(@RequestBody @Valid SalaRequisicao dto) {
        return ResponseEntity.status(201).body(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<SalaResposta>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaResposta> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(
                SalaMapper.toDTO(service.buscarPorId(id))
        );
    }
}
