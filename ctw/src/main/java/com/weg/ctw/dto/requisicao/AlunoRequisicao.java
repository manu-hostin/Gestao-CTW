package com.weg.ctw.dto.requisicao;

import com.weg.ctw.domain.model.Turma;
import jakarta.validation.constraints.*;

import java.util.Date;

public record AlunoRequisicao(
       @NotBlank (message = "O nome é obrigatório")
       @Size(min = 5, message = "O nome deve ultrapassar 5 caracteres")
       String nomeCompleto,

       @NotNull(message = "A data de nascimento é obrigatória")
       @Past(message = "Data inválida")
       Date dataNascimento,

       @NotBlank (message = "O email é obrigatório")
       @Email(message = "Email inválido")
       String email,

       @NotNull(message = "O ID da turma é obrigatório")
       @Positive (message = "Id da turma inválido")
       Integer idTurma

) {
}
