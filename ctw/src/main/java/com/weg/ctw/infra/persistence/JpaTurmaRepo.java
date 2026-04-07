package com.weg.ctw.infra.persistence;

import com.weg.ctw.domain.model.Turma;
import com.weg.ctw.domain.repository.ITurmaRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaTurmaRepo extends JpaRepository<Turma, Integer>, ITurmaRepo {


    @Override
    @Query("SELECT t FROM Turma t WHERE t.id = :id")
    Optional<Turma> buscarTurma(@Param("id") Integer id);

    @Override
    @Query("SELECT t FROM Turma t")
    List<Turma> buscarTurmas();

    @Override
    default Turma salvar(Turma turma) {
        return save(turma);
    }
}