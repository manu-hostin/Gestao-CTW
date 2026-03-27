package com.weg.ctw.infra.strategy;

import com.weg.ctw.domain.model.Professor;
import com.weg.ctw.domain.strategy.IProfessorStrategy;
import org.springframework.stereotype.Component;

@Component
public class ProfessorWegStrategy implements IProfessorStrategy {

    @Override
    public boolean isWegOuSenai(Professor.Instituicao instituicao) {
        return instituicao == Professor.Instituicao.WEG;
    }

    @Override
    public void validar(Professor professor) {
        if (!professor.getEmail().contains("@weg.net")) {
            throw new RuntimeException("E-mail inválido para padrão WEG.");
        }
    }
}