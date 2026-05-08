package com.weg.ctw.mapper;

import com.weg.ctw.domain.model.Sala;
import com.weg.ctw.dto.requisicao.SalaRequisicao;
import com.weg.ctw.dto.resposta.SalaResposta;

public class SalaMapper {

    public static Sala toEntity(SalaRequisicao dto) {
        Sala sala = new Sala();
        sala.setNumeroSala(dto.numeroSala());
        sala.setTipo(dto.tipo());
        sala.setCapacidadeMax(dto.capacidadeMax());
        sala.setRevisada(dto.revisada());
        return sala;
    }

    public static SalaResposta toDTO(Sala sala) {
        return new SalaResposta(
                sala.getId(),
                sala.getNumeroSala(),
                sala.getTipo().name(),
                sala.getCapacidadeMax(),
                sala.isRevisada()
        );
    }
}