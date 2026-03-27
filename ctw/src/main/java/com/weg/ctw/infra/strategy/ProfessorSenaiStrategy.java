package com.weg.ctw.infra.strategy;

import com.weg.ctw.domain.model.Professor;
import com.weg.ctw.domain.strategy.IProfessorStrategy;
import org.springframework.stereotype.Component;

@Component
public class ProfessorSenaiStrategy implements IProfessorStrategy {

    @Override
    public boolean isTipo(String tipo) {
        return "SENAI".equalsIgnoreCase(tipo);
    }

    @Override
    public void validar(Professor professor) {
        if (professor.getNomeCompleto().length() < 10) {
            throw new RuntimeException("Cadastro SENAI exige nome completo sem abreviações!");
        }
    }
}