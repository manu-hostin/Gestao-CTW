package com.weg.ctw.domain.strategy;

import com.weg.ctw.domain.model.Nota;

public interface INotaStrategy {
    boolean isTipo(Nota.TipoNota tipo);
    void validar(double valor);
}