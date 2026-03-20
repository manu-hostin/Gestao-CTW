package com.weg.ctw.domain.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table (name = "professor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data_nascimento;

    @Column(nullable = false)
    private String cpf;

    @Enumerated (EnumType.STRING)
    @Column(name = "instituicao", nullable = false)
    private Instituicao instituicao;


    public enum Instituicao{
        WEG,
        SENAI
    }



}
