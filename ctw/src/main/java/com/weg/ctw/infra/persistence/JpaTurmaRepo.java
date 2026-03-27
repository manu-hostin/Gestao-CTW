package com.weg.ctw.infra.persistence;

import com.weg.ctw.domain.model.Turma;
import com.weg.ctw.domain.repository.ITurmaRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTurmaRepo extends JpaRepository<Turma, Integer>, ITurmaRepo {
}