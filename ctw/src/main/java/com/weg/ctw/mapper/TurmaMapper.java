package com.weg.ctw.mapper;

import com.weg.ctw.domain.model.Turma;
import com.weg.ctw.dto.requisicao.TurmaRequisicao;

public class TurmaMapper {

    public static Turma paraEntidade (TurmaRequisicao dto) {
        Turma turma = new Turma();

        turma.setNome(dto.nome());
        turma.setNumero(dto.numero());
        turma.setCargaHoraria(dto.cargaHoraria());
        turma.setDuracao(dto.duracao());

        return turma;
    }
}
