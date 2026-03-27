package com.weg.ctw.dto.resposta;

public record AulaResposta(
        Integer id,
        Integer duracaoMin,
        String nomeMateria,
        String numeroSala,
        String nomeProfessor,
        String nomeTurma
) {}