package com.weg.ctw.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public enum TipoSala {
        LABORATÓRIO,
        SALA_PRÁTICA,
        SALA_DE_AULA
    }


}
