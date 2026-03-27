package com.weg.ctw.domain.repository;

import com.weg.ctw.domain.model.Sala;
import java.util.List;
import java.util.Optional;

public interface ISalaRepo {
    Sala salvar(Sala sala);

    Optional<Sala> buscarPorId(Integer id);

    List<Sala> listarTodas();

    void deletar(Integer id);
}