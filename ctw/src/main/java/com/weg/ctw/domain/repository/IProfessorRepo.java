package com.weg.ctw.domain.repository;

import com.weg.ctw.domain.model.Professor;

import java.util.List;
import java.util.Optional;

public interface IProfessorRepo {
    Professor salvar (Professor professor);

    Optional<Professor> buscarPorID (Integer id);

    List<Professor> listarProfessores();

    void deletar(Integer id);
}
