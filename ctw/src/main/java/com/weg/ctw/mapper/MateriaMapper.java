package com.weg.ctw.mapper;

import com.weg.ctw.domain.model.Materia;
import com.weg.ctw.dto.requisicao.MateriaRequisicao;
import com.weg.ctw.dto.resposta.MateriaResposta;

public class MateriaMapper {

    public static Materia paraEntidade(MateriaRequisicao dto) {
        Materia materia = new Materia();
        materia.setNome(dto.nome());
        return materia;
    }

    public static MateriaResposta paraResposta(Materia materia) {
        return new MateriaResposta(
                materia.getId(),
                materia.getNome()
        );
    }
}