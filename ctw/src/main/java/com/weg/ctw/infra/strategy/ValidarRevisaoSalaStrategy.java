package com.weg.ctw.infra.strategy;

import com.weg.ctw.domain.model.Sala;
import com.weg.ctw.domain.strategy.SalaDisponivelStrategy;
import org.springframework.stereotype.Component;

@Component
public class ValidarRevisaoSalaStrategy implements SalaDisponivelStrategy {

    @Override
    public void validar (Sala sala) {

        if (!sala.isRevisada()) {
            throw new RuntimeException("A sala " + sala.getNumeroSala() + " não pode ser utilizada pois não foi revisada!");
        }

    }
}