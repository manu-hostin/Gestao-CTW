package com.weg.ctw.service;

import com.weg.ctw.domain.model.Professor;
import com.weg.ctw.domain.model.Turma;
import com.weg.ctw.domain.repository.IProfessorRepo;
import com.weg.ctw.domain.strategy.IProfessorStrategy;
import com.weg.ctw.dto.requisicao.ProfessorRequisicao;
import com.weg.ctw.dto.resposta.ProfessorResposta;
import com.weg.ctw.mapper.ProfessorMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProfessorService {
    private final IProfessorRepo repository;
    private final List<IProfessorStrategy> estrategias;

    public ProfessorResposta salvar(ProfessorRequisicao dto) {
        Professor professor = ProfessorMapper.paraEntidade(dto);

        for (IProfessorStrategy s : estrategias) {
            if (s.isTipo(dto.instituicao().name())) {
                s.validar(professor);
            }
        }

        return ProfessorMapper.paraResposta(repository.salvar(professor));
    }

    public Professor buscarPorId(Integer id) {
        return repository.buscarPorID(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com o ID: " + id));
    }

    public List<ProfessorResposta> listarTodos() {
        List<Professor> listaEntidades = repository.listarProfessores();

        List<ProfessorResposta> listaResposta = new ArrayList<>();

        for (Professor p : listaEntidades) {
            ProfessorResposta resposta = ProfessorMapper.paraResposta(p);
            listaResposta.add(resposta);
        }

        return listaResposta;
    }

    public void deletar(Integer id) {
        repository.deletar(id);
    }
}