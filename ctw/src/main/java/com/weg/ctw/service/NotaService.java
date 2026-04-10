package com.weg.ctw.service;

import com.weg.ctw.domain.model.Aluno;
import com.weg.ctw.domain.model.Materia;
import com.weg.ctw.domain.model.Nota;
import com.weg.ctw.domain.repository.INotaRepo;
import com.weg.ctw.domain.strategy.INotaStrategy;
import com.weg.ctw.dto.requisicao.NotaRequisicao;
import com.weg.ctw.dto.resposta.NotaResposta;
import com.weg.ctw.mapper.NotaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class NotaService {
    private final INotaRepo repository;
    private final AlunoService alunoService;
    private final MateriaService materiaService;
    private final List<INotaStrategy> estrategias;

    public NotaResposta lancarNota(NotaRequisicao dto) {
        Aluno aluno = alunoService.buscarPorId(dto.idAluno());
        Materia materia = materiaService.buscarPorId(dto.idMateria());


        for (INotaStrategy s : estrategias) {
            if (s.isTipo(dto.tipo())) {
                s.validar(dto.valor());
            }
        }

        Nota nota = NotaMapper.paraEntidade(dto, aluno, materia);
        Nota salva = repository.salvar(nota);

        return NotaMapper.paraResposta(salva);
    }

    public List<NotaResposta> listarNotasDoAluno(Integer idAluno) {
        List<Nota> notas = repository.listarPorAluno(idAluno);
        List<NotaResposta> listaResposta = new ArrayList<>();

        for (Nota n : notas) {
            listaResposta.add(NotaMapper.paraResposta(n));
        }

        return listaResposta;
    }

    public void deletar(Integer id) {
        repository.deletar(id);
    }
}