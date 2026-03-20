package com.weg.ctw.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "turma")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int numero;

    @Enumerated(EnumType.STRING)
    @Column(name = "carga_horaria", nullable = false)
    private CargaHoraria cargaHoraria;

    @Enumerated(EnumType.STRING)
    @Column(name = "duracao", nullable = false)
    private Duracao duracao;


    public enum CargaHoraria{
        SEIS_HORAS,
        OITO_HORAS

    }

    public enum Duracao{
        UM_ANO,
        DOIS_ANOS
    }

}
