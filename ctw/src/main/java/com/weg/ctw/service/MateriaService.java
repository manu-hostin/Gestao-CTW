package com.weg.ctw.service;

import com.weg.ctw.domain.model.Materia;
import com.weg.ctw.domain.repository.IMateriaRepo;
import com.weg.ctw.dto.requisicao.MateriaRequisicao;
import com.weg.ctw.mapper.MateriaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MateriaService {

    private final IMateriaRepo repository;

    public Materia salvar(MateriaRequisicao dto) {
        Materia materia = MateriaMapper.paraEntidade(dto);
        return repository.salvar(materia);
    }

    public List<Materia> listarTodas() {
        return repository.listarTodas();
    }

    public Materia buscarPorId(Integer id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Matéria não encontrada com o ID: " + id));
    }

}
