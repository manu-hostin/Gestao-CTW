package com.weg.ctw.infra.persistence;

import com.weg.ctw.domain.model.Materia;
import com.weg.ctw.domain.repository.IMateriaRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMateriaRepo extends JpaRepository<Materia, Integer>, IMateriaRepo {


}
