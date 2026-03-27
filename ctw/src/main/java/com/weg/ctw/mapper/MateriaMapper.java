package com.weg.ctw.mapper;

import com.weg.ctw.domain.model.Materia;
import com.weg.ctw.dto.requisicao.MateriaRequisicao;

public class MateriaMapper {

    public static Materia paraEntidade(MateriaRequisicao dto) {
        Materia materia = new Materia();

        materia.setNome(dto.nome());

        return materia;
    }

}
