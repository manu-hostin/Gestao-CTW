package com.weg.ctw.dto.requisicao;

import com.weg.ctw.domain.model.Professor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.util.Date;

public record ProfessorRequisicao(
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "Email inválido")
        String email,

        @NotNull(message = "A data de nascimento é obrigatória")
        @Past(message = "Data inválida")
        Date dataNascimento,

        @NotBlank(message = "O CPF é obrigatório")
        String cpf,

        @NotNull(message = "A instituição é obrigatória")
        Professor.Instituicao instituicao
) {}