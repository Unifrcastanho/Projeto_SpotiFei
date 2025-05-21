/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Playlists;

/**
 *
 * @author unifrcastanho
 */
public class PlaylistsDAO {
    private Connection conn;

    public PlaylistsDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Playlists playlists) throws SQLException{
        String sql = "select * from playlists where playlistnome = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, playlists.getPlaylistnome());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
}
