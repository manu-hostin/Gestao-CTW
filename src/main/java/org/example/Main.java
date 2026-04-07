package org.example;

public class Main {

    public static void main(String[] args) {

        GerenciadorGeral gerenciador = new GerenciadorGeral();

        System.out.println("===== TURMAS =====");
        gerenciador.cadastrarTurma("Turma A", 1, "SEIS_HORAS", "UM_ANO");
        gerenciador.listarTurmas();

        System.out.println("===== MATÉRIAS =====");
        gerenciador.cadastrarMateria("Matemática", 80);
        gerenciador.listarMaterias();

        System.out.println("===== SALAS =====");
        gerenciador.cadastrarSala("101", "SALA_DE_AULA", 30, true);
        gerenciador.listarSalas();

        System.out.println("===== PROFESSORES =====");
        gerenciador.cadastrarProfessor("Carlos", "carlos@weg.com", "123.456.789-00", "1985-03-10", "WEG");
        gerenciador.cadastrarProfessor("Ana", "ana@senai.com", "987.654.321-00", "1990-07-22", "SENAI");
        gerenciador.listarProfessores();

        System.out.println("===== ALUNOS =====");
        gerenciador.cadastrarAluno("João", "joao@email.com", "2005-01-15", 1);
        gerenciador.listarAlunos();

        System.out.println("===== AULAS =====");
        gerenciador.cadastrarAula(50, 1, 1, 1, 1);
        gerenciador.listarAulas();

        System.out.println("===== NOTAS =====");
        gerenciador.cadastrarNota(1, 1, 8.5, "PRATICA", "REGULAR");
        gerenciador.listarNotas();
    }
}