package com.weg.ctw.mapper;

import com.weg.ctw.domain.model.Aluno;
import com.weg.ctw.domain.model.Turma;
import com.weg.ctw.dto.requisicao.AlunoRequisicao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


public class AlunoMapper {

    public static Aluno paraEntidade (AlunoRequisicao requisicao, Turma turma) {
        Aluno aluno =  new Aluno();

        aluno.setNomeCompleto(requisicao.nomeCompleto());
        aluno.setEmail(requisicao.email());
        aluno.setTurma(turma);
        aluno.setDataNascimento(requisicao.dataNascimento());

        return aluno;
    }

}
