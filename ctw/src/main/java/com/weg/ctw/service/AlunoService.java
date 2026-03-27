package com.weg.ctw.service;

import com.weg.ctw.domain.model.Aluno;
import com.weg.ctw.domain.model.Turma;
import com.weg.ctw.domain.repository.IAlunoRepo;
import com.weg.ctw.dto.requisicao.AlunoRequisicao;
import com.weg.ctw.mapper.AlunoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AlunoService {

    private final IAlunoRepo alunoRepository;
    private final TurmaService turmaService;

    public Aluno salvar(AlunoRequisicao dto) {
        // 1. Buscamos a Turma usando o TurmaService (que já trata o erro se não existir)
        Turma turma = turmaService.buscarPorId(dto.idTurma());

        // 2. Transformamos o DTO em Entidade, passando a Turma que encontramos
        Aluno aluno = AlunoMapper.paraEntidade(dto, turma);

        // 3. Salvamos o aluno
        return alunoRepository.salvar(aluno);
    }

}
