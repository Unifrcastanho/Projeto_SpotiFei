/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author unifrcastanho
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection getConexao() {
        try {            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/Spotifei", "postgres", "fei");

        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão com o banco", e);
        }
    }
}