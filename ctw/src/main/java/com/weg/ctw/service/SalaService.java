package com.weg.ctw.service;

import com.weg.ctw.domain.model.Sala;
import com.weg.ctw.domain.repository.ISalaRepo;
import com.weg.ctw.domain.strategy.SalaDisponivelStrategy;
import com.weg.ctw.dto.requisicao.SalaRequisicao;
import com.weg.ctw.dto.resposta.SalaResposta;
import com.weg.ctw.mapper.SalaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class SalaService {

    private final ISalaRepo repository;

    private final List<SalaDisponivelStrategy> strategies;

    public SalaResposta salvar(SalaRequisicao dto) {
        Sala sala = SalaMapper.toEntity(dto);

        strategies.forEach(s -> s.validar(sala));

        Sala salva = repository.salvar(sala);
        return SalaMapper.toDTO(salva);
    }

    public List<SalaResposta> listarTodas() {
        return repository.listarTodas().stream()
                .map(SalaMapper::toDTO)
                .toList();
    }

    public SalaResposta buscarPorId(Integer id) {
        Sala sala = repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Sala não encontrada com o ID: " + id));
        return SalaMapper.toDTO(sala);
    }

    public void deletar(Integer id) {
        repository.deletar(id);
    }
}