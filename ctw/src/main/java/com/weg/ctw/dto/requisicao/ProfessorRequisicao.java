package com.weg.ctw.dto.requisicao;

import com.weg.ctw.domain.model.Professor;
import java.util.Date;

public record ProfessorRequisicao(
        String nome,
        String email,
        Date dataNascimento,
        String cpf,
        String tipoRegime,
        Professor.Instituicao instituicao
) {}