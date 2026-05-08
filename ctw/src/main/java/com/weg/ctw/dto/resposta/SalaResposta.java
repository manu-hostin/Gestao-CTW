package com.weg.ctw.dto.resposta;

public record SalaResposta(
        Integer id,
        String numeroSala,
        String tipo,
        Integer capacidadeMax,
        boolean revisada
) {
}
