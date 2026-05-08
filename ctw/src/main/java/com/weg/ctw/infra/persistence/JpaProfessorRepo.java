package com.weg.ctw.infra.persistence;

import com.weg.ctw.domain.model.Professor;
import com.weg.ctw.domain.repository.IProfessorRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaProfessorRepo extends JpaRepository<Professor, Integer>, IProfessorRepo {

    @Query("SELECT p FROM Professor p WHERE p.id = :id")
    Optional<Professor> buscarPorID(@Param("id") Integer id);

    @Query("SELECT p FROM Professor p")
    List<Professor> listarProfessores();

    default Professor salvar(Professor professor) {
        return save(professor);
    }

    default void deletar(Integer id) {
        deleteById(id);
    }
}