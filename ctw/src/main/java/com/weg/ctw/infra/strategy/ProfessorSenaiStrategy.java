package com.weg.ctw.infra.strategy;

import com.weg.ctw.domain.model.Professor;
import com.weg.ctw.domain.strategy.IProfessorStrategy;
import org.springframework.stereotype.Component;

@Component
public class ProfessorSenaiStrategy implements IProfessorStrategy {

    @Override
    public boolean isWegOuSenai(Professor.Instituicao instituicao) {
        return instituicao == Professor.Instituicao.SENAI;
    }

    @Override
    public void validar(Professor professor) {

        if (professor.getCpf().length() < 11) {
            throw new RuntimeException("CPF incompleto para cadastro SENAI.");
        }
    }
}