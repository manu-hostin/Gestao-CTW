package com.weg.ctw.service;


import com.weg.ctw.domain.model.Turma;
import com.weg.ctw.domain.repository.ITurmaRepo;
import com.weg.ctw.dto.requisicao.TurmaRequisicao;
import com.weg.ctw.mapper.TurmaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TurmaService {

    private final ITurmaRepo repository; // Interface do Domain

    public Turma salvar(TurmaRequisicao dto) {
        Turma turma = TurmaMapper.paraEntidade(dto);
        return repository.salvar(turma);
    }

    public List<Turma> listartodas() {
        return repository.buscarTurmas();
    }

    public Turma buscarPorId(Integer id) {
        return repository.buscarTurma(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada com o ID: " + id));
    }
}