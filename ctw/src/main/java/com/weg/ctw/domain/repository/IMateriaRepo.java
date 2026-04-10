package com.weg.ctw.domain.repository;

import com.weg.ctw.domain.model.Materia;

import java.util.List;
import java.util.Optional;

public interface IMateriaRepo {

    Materia salvar(Materia materia);
    Optional<Materia> buscarPorId(Integer id);
    List<Materia> listarTodas();
    void deletar(Integer id);
}
