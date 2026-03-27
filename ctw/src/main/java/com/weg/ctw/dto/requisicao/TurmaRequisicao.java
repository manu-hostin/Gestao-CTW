package com.weg.ctw.dto.requisicao;

import com.weg.ctw.domain.model.Turma;

public record TurmaRequisicao(
        String nome,
        int numero,
        Turma.CargaHoraria cargaHoraria,
        Turma.Duracao duracao
) {
}
