/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Artistas;

/**
 *
 * @author unifrcastanho
 */
public class ArtistasDAO {
    private Connection conn;

    public ArtistasDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Artistas artistas) throws SQLException{
        String sql = "select * from artistas where artistanome = ? ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, artistas.getArtistanome());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
}
