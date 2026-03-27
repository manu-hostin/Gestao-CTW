package com.weg.ctw.domain.strategy;

import com.weg.ctw.domain.model.Professor;

public interface IProfessorStrategy {

    boolean isTipo(String tipo);

    void validar(Professor professor);
}

