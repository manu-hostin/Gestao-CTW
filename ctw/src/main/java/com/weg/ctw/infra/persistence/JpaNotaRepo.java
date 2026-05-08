package com.weg.ctw.infra.persistence;

import com.weg.ctw.domain.model.Nota;
import com.weg.ctw.domain.repository.INotaRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaNotaRepo extends JpaRepository<Nota, Integer>, INotaRepo {

    @Query("SELECT n FROM Nota n WHERE n.aluno.id = :idAluno")
    List<Nota> listarPorAluno(@Param("idAluno") Integer idAluno);


    @Query("SELECT n FROM Nota n")
    List<Nota> listarTodas();

    default Nota salvar(Nota nota) {
        return save(nota);
    }

    default void deletar(Integer id) {
        deleteById(id);
    }
}