package com.weg.ctw.dto.resposta;

public record AlunoResposta(
        Integer id,
        String nomeCompleto,
        String email,
        String nomeTurma
) {}