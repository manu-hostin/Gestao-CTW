package com.weg.ctw.dto.resposta;

public record TurmaResposta(
        Integer id,
        String nome,
        int numero,
        String cargaHoraria,
        String duracao
) {}