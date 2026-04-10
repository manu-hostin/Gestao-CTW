package com.weg.ctw.service;

import com.weg.ctw.domain.model.Materia;
import com.weg.ctw.domain.repository.IMateriaRepo;
import com.weg.ctw.dto.requisicao.MateriaRequisicao;
import com.weg.ctw.dto.resposta.MateriaResposta;
import com.weg.ctw.mapper.MateriaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MateriaService {

    private final IMateriaRepo repository;

    public MateriaResposta salvar(MateriaRequisicao dto) {
        Materia materia = MateriaMapper.paraEntidade(dto);
        Materia salva = repository.salvar(materia);

        return MateriaMapper.paraResposta(salva);
    }

    public List<MateriaResposta> listarTodas() {
        List<Materia> materias = repository.listarTodas();
        List<MateriaResposta> listaResposta = new ArrayList<>();

        for (Materia m : materias) {
            listaResposta.add(MateriaMapper.paraResposta(m));
        }

        return listaResposta;
    }


    public Materia buscarPorId(Integer id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Matéria não encontrada com o ID: " + id));
    }

    public void deletar(Integer id) {
        repository.deletar(id);
    }
}