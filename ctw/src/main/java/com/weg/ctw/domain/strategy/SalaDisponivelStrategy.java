package com.weg.ctw.domain.strategy;

import com.weg.ctw.domain.model.Sala;

public interface SalaDisponivelStrategy {
    void validar(Sala sala);
}