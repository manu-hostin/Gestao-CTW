package com.weg.ctw.infra.persistence;

import com.weg.ctw.domain.model.Aula;
import com.weg.ctw.domain.repository.IAulaRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAulaRepo extends JpaRepository<Aula, Integer>, IAulaRepo {}
