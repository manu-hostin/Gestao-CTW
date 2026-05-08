package com.weg.ctw.infra.persistence;

import com.weg.ctw.domain.model.Aula;
import com.weg.ctw.domain.repository.IAulaRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaAulaRepo extends JpaRepository<Aula, Integer>, IAulaRepo {

    @Query("SELECT a FROM Aula a WHERE a.id = :id")
    Optional<Aula> buscarPorId(@Param("id") Integer id);

    @Query("SELECT a FROM Aula a")
    List<Aula> listarTodas();

    default Aula salvar(Aula aula) {
        return save(aula);
    }

    default void deletar(Integer id) {
        deleteById(id);
    }
}