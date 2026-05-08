package com.weg.ctw.service;

import com.weg.ctw.domain.model.Aluno;
import com.weg.ctw.domain.model.Turma;
import com.weg.ctw.domain.repository.IAlunoRepo;
import com.weg.ctw.dto.requisicao.AlunoRequisicao;
import com.weg.ctw.dto.resposta.AlunoResposta;
import com.weg.ctw.mapper.AlunoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AlunoService {
    private final IAlunoRepo alunoRepository;
    private final TurmaService turmaService;

    public AlunoResposta salvar(AlunoRequisicao dto) {
        Turma turma = turmaService.buscarPorId(dto.idTurma());

        Aluno aluno = AlunoMapper.paraEntidade(dto, turma);
        Aluno alunoSalvo = alunoRepository.salvar(aluno);

        return AlunoMapper.paraResposta(alunoSalvo);
    }

    public Aluno buscarPorId(Integer id) {
        return alunoRepository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado: " + id));
    }

    public List<AlunoResposta> listarTodos() {
        List<Aluno> listaEntidades = alunoRepository.listarTodos();

        List<AlunoResposta> listaResposta = new ArrayList<>();

        for (Aluno aluno : listaEntidades) {
            AlunoResposta resposta = AlunoMapper.paraResposta(aluno);
            listaResposta.add(resposta);
        }

        return listaResposta;
    }

    public void deletar(Integer id) {
        alunoRepository.deletar(id);
    }
}