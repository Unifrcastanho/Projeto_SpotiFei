/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author unifrcastanho
 */
public class CurtidasDAO {
    private Connection conn;

    public CurtidasDAO(Connection conn) {
        this.conn = conn;
    }

    public ResultSet listar() throws SQLException {
        String sql = "SELECT m.musictitulo FROM curtidas c JOIN musicas m ON c.musicid = m.musicid WHERE c.curtida = true";
        PreparedStatement stmt = conn.prepareStatement(sql);
        return stmt.executeQuery();
    }

    // Novo método para curtir
    public boolean adicionarCurtida(String tituloMusica) throws SQLException {
        String sql = 
          "INSERT INTO curtidas (musicid, curtida) " +
          "VALUES ((SELECT musicid FROM musicas WHERE musictitulo = ?), true)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tituloMusica);
        return ps.executeUpdate() > 0;
    }
}

