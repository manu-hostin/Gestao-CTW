package com.weg.ctw.infra.persistence;

import com.weg.ctw.domain.model.Aluno;
import com.weg.ctw.domain.repository.IAlunoRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAlunoRepo extends JpaRepository<Aluno, Integer>, IAlunoRepo {
}
