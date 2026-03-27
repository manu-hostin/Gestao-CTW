package com.weg.ctw.dto.requisicao;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AulaRequisicao(

        @NotNull
        Integer idProfessor,
        @NotNull
        Integer idTurma,
        @NotNull
        Integer idMateria,
        @NotBlank
        String sala,
        @NotNull
        Integer duracaoMin
) {
}
//int id
//int duracao_min
//int id_sala
//int id_materia
//int id_turma
//int id_professor