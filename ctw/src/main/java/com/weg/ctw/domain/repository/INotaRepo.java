package com.weg.ctw.domain.repository;

import com.weg.ctw.domain.model.Nota;

import java.util.List;

public interface INotaRepo {

    Nota salvar(Nota nota);

    List<Nota> listarTodas();

    List<Nota> listarPorAluno(Integer idAluno);

    void deletar(Integer id);
}
