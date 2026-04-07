package org.example.model;

public class Nota {
    private int id;
    private int idAluno;
    private int idMateria;
    private double valorNota;
    private String tipo;
    private String finalidade;

    public Nota() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdAluno() { return idAluno; }
    public void setIdAluno(int idAluno) { this.idAluno = idAluno; }

    public int getIdMateria() { return idMateria; }
    public void setIdMateria(int idMateria) { this.idMateria = idMateria; }

    public double getValorNota() { return valorNota; }
    public void setValorNota(double valorNota) { this.valorNota = valorNota; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getFinalidade() { return finalidade; }
    public void setFinalidade(String finalidade) { this.finalidade = finalidade; }
}