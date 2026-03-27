package com.weg.ctw.domain.repository;

import com.weg.ctw.domain.model.Aula;
import java.util.List;
import java.util.Optional;

public interface IAulaRepo {
    Aula salvar(Aula aula);

    Optional<Aula> buscarPorId(Integer id);

    List<Aula> listarTodas();

    void deletar(Integer id);
}