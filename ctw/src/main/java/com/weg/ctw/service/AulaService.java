package com.weg.ctw.service;

import com.weg.ctw.domain.model.*;
import com.weg.ctw.domain.repository.IAulaRepo;
import com.weg.ctw.domain.strategy.SalaDisponivelStrategy;
import com.weg.ctw.dto.requisicao.AulaRequisicao;
import com.weg.ctw.dto.resposta.AulaResposta;
import com.weg.ctw.mapper.AulaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AulaService {

    private final IAulaRepo aulaRepository;
    private final ProfessorService professorService;
    private final TurmaService turmaService;
    private final MateriaService materiaService;
    private final SalaService salaService;

    private final List<SalaDisponivelStrategy> estrategiasSala;

    public AulaResposta agendar(AulaRequisicao dto) {
        Professor prof = professorService.buscarPorId(dto.idProfessor());
        Turma turma = turmaService.buscarPorId(dto.idTurma());
        Materia mat = materiaService.buscarPorId(dto.idMateria());
        Sala sala = salaService.buscarPorId(dto.idSala());

        for (SalaDisponivelStrategy estrategia : estrategiasSala) {
            estrategia.validar(sala);
        }

        Aula aula = AulaMapper.paraEntidade(dto, prof, turma, mat, sala);
        Aula salva = aulaRepository.salvar(aula);

        return AulaMapper.paraResposta(salva);
    }

    public List<AulaResposta> listarTodas() {
        List<Aula> aulas = aulaRepository.listarTodas();
        List<AulaResposta> listaResposta = new ArrayList<>();

        for (Aula aula : aulas) {
            listaResposta.add(AulaMapper.paraResposta(aula));
        }

        return listaResposta;
    }

    public void deletar(Integer id) {
        aulaRepository.deletar(id);
    }
}