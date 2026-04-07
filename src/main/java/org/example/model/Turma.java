package org.example.model;

public class Turma {
    private int id;
    private String nome;
    private int numero;
    private String cargaHoraria;
    private String duracao;

    public Turma() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getCargaHoraria() { return cargaHoraria; }
    public void setCargaHoraria(String cargaHoraria) { this.cargaHoraria = cargaHoraria; }

    public String getDuracao() { return duracao; }
    public void setDuracao(String duracao) { this.duracao = duracao; }
}