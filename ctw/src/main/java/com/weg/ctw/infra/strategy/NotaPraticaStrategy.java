package com.weg.ctw.infra.strategy;

import com.weg.ctw.domain.model.Nota;
import com.weg.ctw.domain.strategy.INotaStrategy;
import org.springframework.stereotype.Component;

@Component
public class NotaPraticaStrategy implements INotaStrategy {

    @Override
    public boolean isTipo(Nota.TipoNota tipo) {
        return tipo == Nota.TipoNota.PRATICA;
    }

    @Override
    public void validar(double valor) {
        if (valor < 0 || valor > 10) {
            throw new RuntimeException("Nota prática inválida! Deve estar entre 0 e 10.");
        }
    }
}