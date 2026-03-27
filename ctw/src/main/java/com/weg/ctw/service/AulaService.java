package com.weg.ctw.service;

import com.weg.ctw.domain.model.*;
import com.weg.ctw.domain.repository.IAulaRepo;
import com.weg.ctw.dto.requisicao.AulaRequisicao;
import com.weg.ctw.mapper.AulaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AulaService {

    private final IAulaRepo aulaRepository;
    private final ProfessorService professorService;
    private final TurmaService turmaService;
    private final MateriaService materiaService;
    private final SalaService salaService;

    public Aula agendar(AulaRequisicao dto) {

        Professor professor = professorService.buscarPorId(dto.idProfessor());
        Turma turma = turmaService.buscarPorId(dto.idTurma());
        Materia materia = materiaService.buscarPorId(dto.idMateria());
        Sala sala = salaService.buscarPorId(dto.idSala());


        Aula aula = AulaMapper.paraEntidade(dto, professor, turma, materia, sala);

        return aulaRepository.salvar(aula);
    }

    public List<Aula> listarTodas() {
        return aulaRepository.listarTodas();
    }
}
