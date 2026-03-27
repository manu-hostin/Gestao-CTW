package com.weg.ctw.dto.requisicao;

import com.weg.ctw.domain.model.Sala;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record SalaRequisicao(
        @NotBlank(message = "O número da sala é obrigatório")
        @Size(min = 1, max = 10, message = "O número da sala deve ter entre 1 e 10 caracteres")
        String numeroSala,

        @NotNull(message = "O tipo da sala é obrigatório")
        Sala.TipoSala tipo,

        @NotNull(message = "A capacidade máxima é obrigatória")
        @Min(value = 1, message = "A capacidade mínima permitida é 1 pessoa")
        Integer capacidadeMax,

        @NotNull(message = "O status de revisão deve ser informado")
        boolean revisada
) {


}
