package com.weg.ctw.domain.strategy;

import com.weg.ctw.domain.model.Professor;

public interface IProfessorStrategy {

    boolean isWegOuSenai (Professor.Instituicao instituicao);

    void validar (Professor professor);
}
