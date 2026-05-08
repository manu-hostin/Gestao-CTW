package com.weg.ctw.domain.strategy;

import com.weg.ctw.domain.model.Nota;

public interface INotaStrategy {

    boolean isTipo(Nota.TipoNota tipo); // Com isso, evitamos um switch ou if/else. Quando  surgir um novo tipo de nota, só criamos uma nova classe

    void validar(double valor);
    
}