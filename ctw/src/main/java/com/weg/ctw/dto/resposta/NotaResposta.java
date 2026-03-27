package com.weg.ctw.dto.resposta;

public record NotaResposta (

        Integer id,
        Double valor,
        String nomeAluno,
        String nomeMateria,
        String tipo,
        String finalidade
){
}
