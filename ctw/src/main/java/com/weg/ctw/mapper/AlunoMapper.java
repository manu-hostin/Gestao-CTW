package com.weg.ctw.mapper;

import com.weg.ctw.domain.model.Aluno;
import com.weg.ctw.domain.model.Turma;
import com.weg.ctw.dto.requisicao.AlunoRequisicao;
import com.weg.ctw.dto.resposta.AlunoResposta;

public class AlunoMapper {

    public static Aluno paraEntidade(AlunoRequisicao requisicao, Turma turma) {
        Aluno aluno = new Aluno();
        aluno.setNomeCompleto(requisicao.nomeCompleto());
        aluno.setEmail(requisicao.email());
        aluno.setTurma(turma);
        aluno.setDataNascimento(requisicao.dataNascimento());
        return aluno;
    }

    public static AlunoResposta paraResposta(Aluno aluno) {
        return new AlunoResposta(
                aluno.getId(),
                aluno.getNomeCompleto(),
                aluno.getEmail(),
                aluno.getTurma().getNome() // Pegamos apenas o texto do nome da turma
        );
    }
}