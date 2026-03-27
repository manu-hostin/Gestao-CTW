package com.weg.ctw.dto.requisicao;

import com.weg.ctw.domain.model.Nota;
import jakarta.validation.constraints.NotNull;

public record NotaRequisicao(

        @NotNull
        Integer idAluno,
        @NotNull
        Integer idMateria,
        @NotNull
        Double valor,
        @NotNull
        Nota.TipoNota tipo,
        @NotNull
        Nota.Finalidade finalidade
) {
}