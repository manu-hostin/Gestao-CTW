package com.weg.ctw.domain.strategy;

import com.weg.ctw.domain.model.Nota;
import org.springframework.stereotype.Component;


public interface INotaStrategy {
    boolean isTipo(Nota.TipoNota tipo);
    void validar(double valor);
}

@Component
class NotaPraticaStrategy implements INotaStrategy {
    public boolean isTipo(Nota.TipoNota tipo) { return tipo == Nota.TipoNota.PRATICA; }
    public void validar(double valor) {
        if (valor < 0 || valor > 10) throw new RuntimeException("Nota inválida!");
    }
}

@Component
class NotaObjetivaStrategy implements INotaStrategy {
    public boolean isTipo(Nota.TipoNota tipo) { return tipo == Nota.TipoNota.OBJETIVA; }
    public void validar(double valor) {
        if (valor < 0 || valor > 10) throw new RuntimeException("Nota inválida!");
    }
}
