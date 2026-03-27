package com.weg.ctw.mapper;

import com.weg.ctw.domain.model.*;
import com.weg.ctw.dto.requisicao.AulaRequisicao;

public class AulaMapper {

    public static Aula paraEntidade(AulaRequisicao dto, Professor professor, Turma turma, Materia materia, Sala sala) {
        Aula aula = new Aula();

        aula.setDuracaoMin(dto.duracaoMin());
        aula.setProfessor(professor);
        aula.setTurma(turma);
        aula.setMateria(materia);
        aula.setSala(sala);

        return aula;
    }

}
