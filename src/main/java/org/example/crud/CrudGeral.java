package org.example.crud;
public interface CrudGeral {

    void cadastrarAluno(String nome, String email, String dataNasc, int idTurma);
    void alterarAluno(int id, String nome, String email);
    void listarAlunos();
    void deletarAluno(int id);

    // Professor
    void cadastrarProfessor(String nome, String email, String cpf, String dataNasc, String instituicao);
    void alterarProfessor(int id, String nome, String email);
    void listarProfessores();
    void deletarProfessor(int id);

    // Sala
    void cadastrarSala(String numero, String tipo, int capacidade, boolean revisada);
    void alterarSala(int id, String numero, String tipo);
    void listarSalas();
    void deletarSala(int id);

    // Matéria
    void cadastrarMateria(String nome, int cargaHoraria);
    void alterarMateria(int id, String nome, int cargaHoraria);
    void listarMaterias();
    void deletarMateria(int id);

    // Turma
    void cadastrarTurma(String nome, int numero, String cargaHoraria, String duracao);
    void alterarTurma(int id, String nome, int numero);
    void listarTurmas();
    void deletarTurma(int id);

    // Nota
    void cadastrarNota(int idAluno, int idMateria, double valor, String tipo, String finalidade);
    void alterarNota(int id, double valor);
    void listarNotas();
    void deletarNota(int id);

    // Aula
    void cadastrarAula(int duracaoMin, int idSala, int idMateria, int idTurma, int idProfessor);
    void alterarAula(int id, int duracaoMin);
    void listarAulas();
    void deletarAula(int id);
}