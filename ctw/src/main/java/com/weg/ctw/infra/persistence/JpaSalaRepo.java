package com.weg.ctw.infra.persistence;

import com.weg.ctw.domain.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Essa interface o Spring preenche sozinho com o Hibernate/JPA
@Repository
interface JpaSalaRepo extends JpaRepository<Sala, Integer> {
}