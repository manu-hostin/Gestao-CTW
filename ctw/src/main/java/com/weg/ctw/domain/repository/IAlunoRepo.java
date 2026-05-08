package com.weg.ctw.domain.repository;

import com.weg.ctw.domain.model.Aluno;
import java.util.List;
import java.util.Optional;

public interface IAlunoRepo {

        // define o que o sistema precisa fazer com alunos, JpaAluno define como isso é feito
        // Se precisar trocar o MySQL por MongoDB, crimaos nova interface MongoAlunoRepo implementando IAlunoRepo, o service não muda
        Aluno salvar(Aluno aluno);

        Optional<Aluno> buscarPorId(Integer id);

        List<Aluno> listarTodos();

        void deletar(Integer id);

}
