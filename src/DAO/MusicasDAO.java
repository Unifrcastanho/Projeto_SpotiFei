/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Musicas;

/**
 *
 * @author unifrcastanho
 */
public class MusicasDAO {
    private Connection conn;

    public MusicasDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Musicas musicas) throws SQLException{
        String sql = "select * from musicas where musicid = ? or musicatitulo = ? or musicagenero = ? ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, musicas.getMusicid());
        statement.setString(2, musicas.getMusicgenero());
        statement.setString(3, musicas.getMusictitulo());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
}
