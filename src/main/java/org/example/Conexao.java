package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {


    private static final String URL = "jdbc:mysql://localhost:3306/CTW";
    private static final String USER = "root";
    private static final String PASS = "mysqlPW";

    public static Connection getConnection() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("[LOG] Conectando ao banco...");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("[ERRO] Driver MySQL não encontrado! Adicione o JAR ao projeto.");
            return null;
        } catch (Exception e) {
            System.out.println("[ERRO] Falha na conexão: " + e.getMessage());
            return null;
        }
    }
}