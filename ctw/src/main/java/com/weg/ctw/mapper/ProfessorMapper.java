package com.weg.ctw.mapper;

import com.weg.ctw.domain.model.Professor;
import com.weg.ctw.dto.requisicao.ProfessorRequisicao;

public class ProfessorMapper {
    public static Professor paraEntidade(ProfessorRequisicao dto) {
        Professor prof = new Professor();
        prof.setNomeCompleto(dto.nome());
        prof.setEmail(dto.email());
        prof.setData_nascimento(dto.dataNascimento());
        prof.setCpf(dto.cpf());
        prof.setInstituicao(dto.instituicao());
        return prof;
    }
}