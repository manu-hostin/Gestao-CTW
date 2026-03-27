package com.weg.ctw.dto.resposta;

public record ProfessorResposta(
        Integer id,
        String nome,
        String especialidade,
        String tipoRegime
) {}