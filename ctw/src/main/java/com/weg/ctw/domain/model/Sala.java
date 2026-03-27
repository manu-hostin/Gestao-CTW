package com.weg.ctw.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "sala")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sala {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String numeroSala;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoSala tipo;

    @Column(nullable = false)
    private Integer capacidadeMax;

    @Column(nullable = false)
    private boolean revisada;

    @OneToMany(mappedBy = "sala")
    private List<Aula> aulas;

    public enum TipoSala {
        LABORATÓRIO,
        SALA_PRÁTICA,
        SALA_DE_AULA
    }


}
