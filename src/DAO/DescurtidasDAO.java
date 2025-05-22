/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
/**
 *
 * @author rodri
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DescurtidasDAO {
    private Connection conn;

    public DescurtidasDAO(Connection conn) {
        this.conn = conn;
    }

    public ResultSet listar() throws SQLException {
        String sql = "SELECT m.musictitulo FROM curtidas c JOIN musicas m ON c.musicid = m.musicid WHERE c.curtida = false";
        PreparedStatement stmt = conn.prepareStatement(sql);
        return stmt.executeQuery();
    }

    // Novo método para descurtir
    public boolean adicionarDescurtida(String tituloMusica) throws SQLException {
        String sql = 
          "INSERT INTO curtidas (musicid, curtida) " +
          "VALUES ((SELECT musicid FROM musicas WHERE musictitulo = ?), false)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tituloMusica);
        return ps.executeUpdate() > 0;
    }
}

