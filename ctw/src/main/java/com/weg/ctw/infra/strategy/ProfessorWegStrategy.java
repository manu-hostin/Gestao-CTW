package com.weg.ctw.infra.strategy;

import com.weg.ctw.domain.model.Professor;
import com.weg.ctw.domain.strategy.IProfessorStrategy;
import org.springframework.stereotype.Component;

@Component
public class ProfessorWegStrategy implements IProfessorStrategy {

    @Override
    public boolean isTipo(String tipo) {
        return "WEG".equalsIgnoreCase(tipo);
    }

    @Override
    public void validar(Professor professor) {

        if (!professor.getEmail().endsWith("@weg.net")) {
            throw new RuntimeException("Professor WEG deve usar email @weg.net");
        }
    }
}