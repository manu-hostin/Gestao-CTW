package com.weg.ctw.service;

import com.weg.ctw.domain.model.Professor;
import com.weg.ctw.domain.model.Turma;
import com.weg.ctw.domain.repository.IProfessorRepo;
import com.weg.ctw.domain.strategy.IProfessorStrategy;
import com.weg.ctw.dto.requisicao.ProfessorRequisicao;
import com.weg.ctw.mapper.ProfessorMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProfessorService {

    private final IProfessorRepo repository;
    private final List<IProfessorStrategy> estrategias;

    public Professor salvar(ProfessorRequisicao dto) {
        Professor professor = ProfessorMapper.paraEntidade(dto);

        estrategias.stream()
                .filter(s -> s.isWegOuSenai(professor.getInstituicao()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Estratégia não encontrada"))
                .validar(professor);

        return repository.salvar(professor);
    }

    public List<Professor> listarProfessores () {
        return repository.listarProfessores();
    }

    public Professor buscarPorId(Integer id) {
        return repository.buscarPorID(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com o ID: " + id));
    }
}