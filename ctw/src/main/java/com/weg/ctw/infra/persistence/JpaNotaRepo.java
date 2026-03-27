package com.weg.ctw.infra.persistence;

import com.weg.ctw.domain.model.Nota;
import com.weg.ctw.domain.repository.INotaRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface JpaNotaRepo extends JpaRepository<Nota, Integer>, INotaRepo {


    }

