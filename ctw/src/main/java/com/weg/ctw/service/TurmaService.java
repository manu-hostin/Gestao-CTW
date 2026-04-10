package com.weg.ctw.service;

import com.weg.ctw.domain.model.Turma;
import com.weg.ctw.domain.repository.ITurmaRepo;
import com.weg.ctw.dto.requisicao.TurmaRequisicao;
import com.weg.ctw.dto.resposta.TurmaResposta;
import com.weg.ctw.mapper.TurmaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TurmaService {

    private final ITurmaRepo repository;

    public TurmaResposta salvar(TurmaRequisicao dto) {
        Turma turma = TurmaMapper.paraEntidade(dto);
        Turma salva = repository.salvar(turma);
        return TurmaMapper.paraResposta(salva);
    }

    public List<TurmaResposta> listarTodas() {
        return repository.buscarTurmas()
                .stream()
                .map(TurmaMapper::paraResposta)
                .toList();
    }

    public Turma buscarPorId(Integer id) {
        return repository.buscarTurma(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada com o ID: " + id));
    }

    public void deletar(Integer id) {
        repository.deletar(id);
    }
}