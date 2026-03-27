package com.weg.ctw.dto.requisicao;

import jakarta.validation.constraints.NotBlank;

public record MateriaRequisicao(
        @NotBlank(message = "O nome da matéria é obrigatório")
        String nome
) {
}