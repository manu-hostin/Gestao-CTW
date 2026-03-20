package com.weg.ctw.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "nota")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_aluno", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "id_materia", nullable = false)
    private Materia materia;

    @Column(nullable = false)
    private double valorNota;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoNota tipo;

    @Enumerated (EnumType.STRING)
    @Column (name = "finalidade")
    private Finalidade finalidade;

    public enum TipoNota {
        PRATICA,
        OBJETIVA,
        DESCRITIVA
    }

    public enum Finalidade {
        REGULAR,
        RECUPERACAO,
        EXAME
    }

}