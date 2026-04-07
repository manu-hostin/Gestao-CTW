package com.weg.ctw.dto.requisicao;

import com.weg.ctw.domain.model.Turma;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TurmaRequisicao(
        @NotBlank(message = "O nome da turma é obrigatório")
        String nome,

        @NotNull(message = "O número é obrigatório")
        int numero,

        @NotNull(message = "A carga horária é obrigatória")
        Turma.CargaHoraria cargaHoraria,

        @NotNull(message = "A duração é obrigatória")
        Turma.Duracao duracao
) {}