package com.weg.ctw.dto.requisicao;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MateriaRequisicao(
        @NotBlank(message = "O nome da matéria é obrigatório")
        String nome,

        @NotNull(message = "A carga horária é obrigatória")
        @Min(value = 1, message = "A carga horária deve ser maior que zero")
        Integer cargaHoraria
) {
}