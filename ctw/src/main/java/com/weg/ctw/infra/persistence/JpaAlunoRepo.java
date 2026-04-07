package com.weg.ctw.infra.persistence;

import com.weg.ctw.domain.model.Aluno;
import com.weg.ctw.domain.repository.IAlunoRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaAlunoRepo extends JpaRepository<Aluno, Integer>, IAlunoRepo {

    @Override
    @Query("SELECT a FROM Aluno a WHERE a.id = :id")
    Optional<Aluno> buscarPorId(@Param("id") Integer id);

    @Override
    @Query("SELECT a FROM Aluno a")
    List<Aluno> listarTodos();

    @Override
    default Aluno salvar(Aluno aluno) {
        return save(aluno);
    }

    @Override
    default void deletar(Integer id) {
        deleteById(id);
    }
}