package com.weg.ctw.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name = "aluno")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE) // Define que no banco será apenas YYYY-MM-DD
    private Date dataNascimento;

    @Column(unique = true, nullable = false)
    private String email;

   @ManyToOne
    @JoinColumn(name = "id_turma", nullable = false)
    private Turma turma;
}
