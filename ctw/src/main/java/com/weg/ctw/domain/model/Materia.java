package com.weg.ctw.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "materia")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column (nullable = false)
    private String nome;

    @Column (nullable = false)
    private Integer cargaHoraria;


    @OneToMany(mappedBy = "materia")
    private List<Aula> aulas;

    @OneToMany(mappedBy = "materia")
    private List<Nota> notas;

}
