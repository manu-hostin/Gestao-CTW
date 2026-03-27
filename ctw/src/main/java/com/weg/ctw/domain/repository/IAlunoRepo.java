package com.weg.ctw.domain.repository;

import com.weg.ctw.domain.model.Aluno;
import java.util.List;
import java.util.Optional;

public interface IAlunoRepo {

        Aluno salvar(Aluno aluno);

        Optional<Aluno> buscarPorId(Integer id);

        List<Aluno> listarTodos();

        void deletar(Integer id);

}
