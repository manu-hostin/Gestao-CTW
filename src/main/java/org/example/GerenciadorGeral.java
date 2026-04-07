package org.example;

import org.example.crud.CrudGeral;
import org.example.notificador.*;
import org.example.Conexao;

import java.sql.*;
public class GerenciadorGeral implements CrudGeral {

    private org.example.notificador.Notificador notificador = new org.example.notificador.Notificador("LOG");


    @Override
    public void cadastrarAluno(String nome, String email, String dataNasc, int idTurma) {
        String sql = "INSERT INTO aluno (nome, email, data_nascimento, id_turma) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setString(3, dataNasc);
            ps.setInt(4, idTurma);
            ps.executeUpdate();
            notificador.notificar("Aluno cadastrado: " + nome);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
        }
    }

    @Override
    public void alterarAluno(int id, String nome, String email) {
        String sql = "UPDATE aluno SET nome = ?, email = ? WHERE id = ?";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setInt(3, id);
            ps.executeUpdate();
            notificador.notificar("Aluno alterado: id=" + id);
        } catch (Exception e) {
            System.out.println("Erro ao alterar aluno: " + e.getMessage());
        }
    }

    @Override
    public void listarAlunos() {
        String sql = "SELECT * FROM aluno";
        try (Connection con = Conexao.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + " | Nome: " + rs.getString("nome")
                        + " | Email: " + rs.getString("email")
                        + " | Turma: " + rs.getInt("id_turma"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar alunos: " + e.getMessage());
        }
    }

    @Override
    public void deletarAluno(int id) {
        String sql = "DELETE FROM aluno WHERE id = ?";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            notificador.notificar("Aluno deletado: id=" + id);
        } catch (Exception e) {
            System.out.println("Erro ao deletar aluno: " + e.getMessage());
        }
    }


    @Override
    public void cadastrarProfessor(String nome, String email, String cpf, String dataNasc, String instituicao) {
        if (!instituicao.equals("WEG") && !instituicao.equals("SENAI")) {
            System.out.println("Instituição inválida! Use WEG ou SENAI.");
            return;
        }
        String sql = "INSERT INTO professor (nome, email, cpf, data_nascimento, instituicao) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setString(3, cpf);
            ps.setString(4, dataNasc);
            ps.setString(5, instituicao);
            ps.executeUpdate();
            notificador.notificar("Professor cadastrado: " + nome + " (" + instituicao + ")");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar professor: " + e.getMessage());
        }
    }

    @Override
    public void alterarProfessor(int id, String nome, String email) {
        String sql = "UPDATE professor SET nome = ?, email = ? WHERE id = ?";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setInt(3, id);
            ps.executeUpdate();
            notificador.notificar("Professor alterado: id=" + id);
        } catch (Exception e) {
            System.out.println("Erro ao alterar professor: " + e.getMessage());
        }
    }

    @Override
    public void listarProfessores() {
        String sql = "SELECT * FROM professor";
        try (Connection con = Conexao.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + " | Nome: " + rs.getString("nome")
                        + " | Instituição: " + rs.getString("instituicao"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar professores: " + e.getMessage());
        }
    }

    @Override
    public void deletarProfessor(int id) {
        String sql = "DELETE FROM professor WHERE id = ?";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            notificador.notificar("Professor deletado: id=" + id);
        } catch (Exception e) {
            System.out.println("Erro ao deletar professor: " + e.getMessage());
        }
    }


    @Override
    public void cadastrarSala(String numero, String tipo, int capacidade, boolean revisada) {
        String sql = "INSERT INTO sala (numero_sala, tipo, capacidade_max, revisada) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, numero);
            ps.setString(2, tipo);
            ps.setInt(3, capacidade);
            ps.setBoolean(4, revisada);
            ps.executeUpdate();
            notificador.notificar("Sala cadastrada: " + numero);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar sala: " + e.getMessage());
        }
    }

    @Override
    public void alterarSala(int id, String numero, String tipo) {
        String sql = "UPDATE sala SET numero_sala = ?, tipo = ? WHERE id = ?";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, numero);
            ps.setString(2, tipo);
            ps.setInt(3, id);
            ps.executeUpdate();
            notificador.notificar("Sala alterada: id=" + id);
        } catch (Exception e) {
            System.out.println("Erro ao alterar sala: " + e.getMessage());
        }
    }

    @Override
    public void listarSalas() {
        String sql = "SELECT * FROM sala";
        try (Connection con = Conexao.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + " | Número: " + rs.getString("numero_sala")
                        + " | Tipo: " + rs.getString("tipo")
                        + " | Capacidade: " + rs.getInt("capacidade_max")
                        + " | Revisada: " + rs.getBoolean("revisada"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar salas: " + e.getMessage());
        }
    }

    @Override
    public void deletarSala(int id) {
        String sql = "DELETE FROM sala WHERE id = ?";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            notificador.notificar("Sala deletada: id=" + id);
        } catch (Exception e) {
            System.out.println("Erro ao deletar sala: " + e.getMessage());
        }
    }


    @Override
    public void cadastrarMateria(String nome, int cargaHoraria) {
        String sql = "INSERT INTO materia (nome, carga_horaria) VALUES (?, ?)";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nome);
            ps.setInt(2, cargaHoraria);
            ps.executeUpdate();
            notificador.notificar("Matéria cadastrada: " + nome);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar matéria: " + e.getMessage());
        }
    }

    @Override
    public void alterarMateria(int id, String nome, int cargaHoraria) {
        String sql = "UPDATE materia SET nome = ?, carga_horaria = ? WHERE id = ?";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nome);
            ps.setInt(2, cargaHoraria);
            ps.setInt(3, id);
            ps.executeUpdate();
            notificador.notificar("Matéria alterada: id=" + id);
        } catch (Exception e) {
            System.out.println("Erro ao alterar matéria: " + e.getMessage());
        }
    }

    @Override
    public void listarMaterias() {
        String sql = "SELECT * FROM materia";
        try (Connection con = Conexao.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + " | Nome: " + rs.getString("nome")
                        + " | Carga Horária: " + rs.getInt("carga_horaria") + "h");
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar matérias: " + e.getMessage());
        }
    }

    @Override
    public void deletarMateria(int id) {
        String sql = "DELETE FROM materia WHERE id = ?";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            notificador.notificar("Matéria deletada: id=" + id);
        } catch (Exception e) {
            System.out.println("Erro ao deletar matéria: " + e.getMessage());
        }
    }



    @Override
    public void cadastrarTurma(String nome, int numero, String cargaHoraria, String duracao) {
        String sql = "INSERT INTO turma (nome, numero, carga_horaria, duracao) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nome);
            ps.setInt(2, numero);
            ps.setString(3, cargaHoraria);
            ps.setString(4, duracao);
            ps.executeUpdate();
            notificador.notificar("Turma cadastrada: " + nome);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar turma: " + e.getMessage());
        }
    }

    @Override
    public void alterarTurma(int id, String nome, int numero) {
        String sql = "UPDATE turma SET nome = ?, numero = ? WHERE id = ?";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nome);
            ps.setInt(2, numero);
            ps.setInt(3, id);
            ps.executeUpdate();
            notificador.notificar("Turma alterada: id=" + id);
        } catch (Exception e) {
            System.out.println("Erro ao alterar turma: " + e.getMessage());
        }
    }

    @Override
    public void listarTurmas() {
        String sql = "SELECT * FROM turma";
        try (Connection con = Conexao.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + " | Nome: " + rs.getString("nome")
                        + " | Carga: " + rs.getString("carga_horaria")
                        + " | Duração: " + rs.getString("duracao"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar turmas: " + e.getMessage());
        }
    }

    @Override
    public void deletarTurma(int id) {
        String sql = "DELETE FROM turma WHERE id = ?";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            notificador.notificar("Turma deletada: id=" + id);
        } catch (Exception e) {
            System.out.println("Erro ao deletar turma: " + e.getMessage());
        }
    }



    @Override
    public void cadastrarNota(int idAluno, int idMateria, double valor, String tipo, String finalidade) {

        if (!tipo.equals("PRATICA") && !tipo.equals("OBJETIVA") && !tipo.equals("DESCRITIVA")) {
            System.out.println("Tipo de nota inválido!");
            return;
        }
        String sql = "INSERT INTO nota (id_aluno, id_materia, valor_nota, tipo, finalidade) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idAluno);
            ps.setInt(2, idMateria);
            ps.setDouble(3, valor);
            ps.setString(4, tipo);
            ps.setString(5, finalidade);
            ps.executeUpdate();
            notificador.notificar("Nota cadastrada para aluno id=" + idAluno);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar nota: " + e.getMessage());
        }
    }

    @Override
    public void alterarNota(int id, double valor) {
        String sql = "UPDATE nota SET valor_nota = ? WHERE id = ?";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, valor);
            ps.setInt(2, id);
            ps.executeUpdate();
            notificador.notificar("Nota alterada: id=" + id);
        } catch (Exception e) {
            System.out.println("Erro ao alterar nota: " + e.getMessage());
        }
    }

    @Override
    public void listarNotas() {
        String sql = "SELECT * FROM nota";
        try (Connection con = Conexao.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + " | Aluno: " + rs.getInt("id_aluno")
                        + " | Matéria: " + rs.getInt("id_materia")
                        + " | Valor: " + rs.getDouble("valor_nota")
                        + " | Tipo: " + rs.getString("tipo")
                        + " | Finalidade: " + rs.getString("finalidade"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar notas: " + e.getMessage());
        }
    }

    @Override
    public void deletarNota(int id) {
        String sql = "DELETE FROM nota WHERE id = ?";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            notificador.notificar("Nota deletada: id=" + id);
        } catch (Exception e) {
            System.out.println("Erro ao deletar nota: " + e.getMessage());
        }
    }

    @Override
    public void cadastrarAula(int duracaoMin, int idSala, int idMateria, int idTurma, int idProfessor) {
        String sql = "INSERT INTO aula (duracao_min, id_sala, id_materia, id_turma, id_professor) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, duracaoMin);
            ps.setInt(2, idSala);
            ps.setInt(3, idMateria);
            ps.setInt(4, idTurma);
            ps.setInt(5, idProfessor);
            ps.executeUpdate();
            notificador.notificar("Aula cadastrada na sala id=" + idSala);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar aula: " + e.getMessage());
        }
    }

    @Override
    public void alterarAula(int id, int duracaoMin) {
        String sql = "UPDATE aula SET duracao_min = ? WHERE id = ?";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, duracaoMin);
            ps.setInt(2, id);
            ps.executeUpdate();
            notificador.notificar("Aula alterada: id=" + id);
        } catch (Exception e) {
            System.out.println("Erro ao alterar aula: " + e.getMessage());
        }
    }

    @Override
    public void listarAulas() {
        String sql = "SELECT * FROM aula";
        try (Connection con = Conexao.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + " | Duração: " + rs.getInt("duracao_min") + "min"
                        + " | Sala: " + rs.getInt("id_sala")
                        + " | Professor: " + rs.getInt("id_professor"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar aulas: " + e.getMessage());
        }
    }

    @Override
    public void deletarAula(int id) {
        String sql = "DELETE FROM aula WHERE id = ?";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            notificador.notificar("Aula deletada: id=" + id);
        } catch (Exception e) {
            System.out.println("Erro ao deletar aula: " + e.getMessage());
        }
    }
}