package com.weg.ctw.infra.persistence;

import com.weg.ctw.domain.model.Professor;
import com.weg.ctw.domain.repository.IProfessorRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProfessorRepo extends JpaRepository<Professor, Integer>, IProfessorRepo {
}
