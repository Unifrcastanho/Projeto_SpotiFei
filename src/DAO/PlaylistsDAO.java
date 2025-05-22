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
public class PlaylistsDAO {
    private Connection conn;

    public PlaylistsDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet listarPlaylists() throws SQLException {
        String sql = "SELECT playlistnome FROM playlists ORDER BY playlistnome";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        return statement.getResultSet();
    }

    public boolean criarPlaylist(String nome) throws SQLException {
        String sql = "INSERT INTO playlists (playlistnome) VALUES (?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, nome);
        return statement.executeUpdate() > 0;
    }

    public boolean excluirPlaylist(String nome) throws SQLException {
        String sql = "DELETE FROM playlists WHERE playlistnome = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, nome);
        return statement.executeUpdate() > 0;
    }
}
