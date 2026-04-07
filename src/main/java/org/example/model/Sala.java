package org.example.model;

public class Sala {
    private int id;
    private String numeroSala;
    private String tipo;
    private int capacidadeMax;
    private boolean revisada;

    public Sala() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNumeroSala() { return numeroSala; }
    public void setNumeroSala(String numeroSala) { this.numeroSala = numeroSala; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getCapacidadeMax() { return capacidadeMax; }
    public void setCapacidadeMax(int capacidadeMax) { this.capacidadeMax = capacidadeMax; }

    public boolean isRevisada() { return revisada; }
    public void setRevisada(boolean revisada) { this.revisada = revisada; }
}