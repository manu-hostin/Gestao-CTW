package com.weg.ctw.domain.repository;

import com.weg.ctw.domain.model.Turma;


import java.util.List;
import java.util.Optional;

public interface ITurmaRepo {

    Turma salvar (Turma turma);

    Optional<Turma> buscarTurma (Integer id);

    List<Turma> buscarTurmas ();
}
