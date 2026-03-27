package com.weg.ctw.dto.requisicao;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AulaRequisicao(
        @NotNull(message = "O ID do professor é obrigatório")
        Integer idProfessor,

        @NotNull(message = "O ID da turma é obrigatório")
        Integer idTurma,

        @NotNull(message = "O ID da matéria é obrigatório")
        Integer idMateria,

        @NotNull(message = "O ID da sala é obrigatório")
        Integer idSala,

        @NotNull(message = "A duração é obrigatória")
        @Positive
        Integer duracaoMin
) {
}