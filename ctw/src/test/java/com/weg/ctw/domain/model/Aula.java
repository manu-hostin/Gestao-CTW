package com.weg.ctw.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "aula")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "duracao_min", nullable = false)
    private Integer duracaoMin;

    @JoinColumn(name = "id_sala", nullable = false)
    private Sala sala;

    @JoinColumn(name = "id_materia", nullable = false)
    private Materia materia;

    @JoinColumn(name = "id_turma", nullable = false)
    private Turma turma;

    @JoinColumn(name = "id_professor", nullable = false)
    private Professor professor;
}
