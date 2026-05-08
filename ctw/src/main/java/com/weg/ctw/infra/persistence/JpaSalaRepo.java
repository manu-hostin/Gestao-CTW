package com.weg.ctw.infra.persistence;

import com.weg.ctw.domain.model.Sala;
import com.weg.ctw.domain.repository.ISalaRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaSalaRepo extends JpaRepository<Sala, Integer>, ISalaRepo {

    @Query("SELECT s FROM Sala s WHERE s.id = :id")
    Optional<Sala> buscarPorId(@Param("id") Integer id);

    @Query("SELECT s FROM Sala s")
    List<Sala> listarTodas();

    default Sala salvar(Sala sala) {
        return save(sala);
    }

    default void deletar(Integer id) {
        deleteById(id);
    }
}