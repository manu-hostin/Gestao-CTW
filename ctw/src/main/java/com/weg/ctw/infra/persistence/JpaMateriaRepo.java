package com.weg.ctw.infra.persistence;

import com.weg.ctw.domain.model.Materia;
import com.weg.ctw.domain.repository.IMateriaRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaMateriaRepo extends JpaRepository<Materia, Integer>, IMateriaRepo {

    @Override
    @Query("SELECT m FROM Materia m WHERE m.id = :id")
    Optional<Materia> buscarPorId(@Param("id") Integer id);

    @Override
    @Query("SELECT m FROM Materia m")
    List<Materia> listarTodas();

    @Override
    default Materia salvar(Materia materia) {
        return save(materia);
    }

    @Override
    default void deletar(Integer id) {
        deleteById(id);
    }
}