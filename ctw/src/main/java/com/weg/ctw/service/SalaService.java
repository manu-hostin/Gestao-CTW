package com.weg.ctw.service;

import com.weg.ctw.domain.model.Sala;
import com.weg.ctw.domain.repository.ISalaRepo;
import com.weg.ctw.dto.requisicao.SalaRequisicao;
import com.weg.ctw.dto.resposta.SalaResposta;
import com.weg.ctw.mapper.SalaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class SalaService {
    private final ISalaRepo repository;

    public SalaResposta salvar(SalaRequisicao dto) {
        Sala sala = SalaMapper.toEntity(dto);
        Sala salva = repository.salvar(sala);
        return SalaMapper.toDTO(salva);
    }

    public Sala buscarPorId(Integer id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Sala não encontrada: " + id));
    }

    public List<SalaResposta> listarTodas() {
        List<Sala> entidades = repository.listarTodas();
        List<SalaResposta> respostas = new ArrayList<>();
        for (Sala s : entidades) {
            respostas.add(SalaMapper.toDTO(s));
        }
        return respostas;
    }

    public void deletar(Integer id) {
        repository.deletar(id);
    }
}