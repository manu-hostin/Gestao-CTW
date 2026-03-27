package com.weg.ctw.mapper;

import com.weg.ctw.domain.model.Aluno;
import com.weg.ctw.domain.model.Materia;
import com.weg.ctw.domain.model.Nota;
import com.weg.ctw.dto.requisicao.NotaRequisicao;
import com.weg.ctw.dto.resposta.NotaResposta;

public class NotaMapper {
    public static Nota paraEntidade(NotaRequisicao dto, Aluno aluno, Materia materia) {
        Nota nota = new Nota();
        nota.setValorNota(dto.valor());
        nota.setTipo(dto.tipo());
        nota.setFinalidade(dto.finalidade());
        nota.setAluno(aluno);
        nota.setMateria(materia);
        return nota;
    }

    public static NotaResposta paraResposta(Nota nota) {
        return new NotaResposta(
                nota.getId(),
                nota.getValorNota(),
                nota.getAluno().getNomeCompleto(),
                nota.getMateria().getNome(),
                nota.getTipo().name(),
                nota.getFinalidade().name()
        );
    }
}
