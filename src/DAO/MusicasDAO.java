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
public class MusicasDAO {
    private Connection conn;

    public MusicasDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet listarMusicasPorPlaylist(String nomePlaylist) throws SQLException {
        String sql = "SELECT m.musictitulo FROM musicas m " +
                     "JOIN playlists_musicas pm ON m.musictitulo = pm.musicatitulo " +
                     "WHERE pm.playlistnome = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, nomePlaylist);
        statement.execute();
        return statement.getResultSet();
    }

    public boolean adicionarMusicaNaPlaylist(String tituloMusica, String nomePlaylist) throws SQLException {
        String sql = "INSERT INTO playlists_musicas (playlistnome, musicatitulo) VALUES (?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, nomePlaylist);
        statement.setString(2, tituloMusica);
        return statement.executeUpdate() > 0;
    }

    public boolean removerMusicaDaPlaylist(String tituloMusica, String nomePlaylist) throws SQLException {
        String sql = "DELETE FROM playlists_musicas WHERE playlistnome = ? AND musicatitulo = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, nomePlaylist);
        statement.setString(2, tituloMusica);
        return statement.executeUpdate() > 0;
    }
    
    public ResultSet buscarPorFiltros(String titulo, String artista, String genero) throws SQLException {
    String sql = "SELECT musicid, musictitulo, musicgenero FROM musicas "
               + "WHERE musictitulo ILIKE ? AND musicgenero ILIKE ? AND musicid IN ("
               + "   SELECT musicid FROM musicas_artistas WHERE artistaid IN ("
               + "       SELECT artistaid FROM artistas WHERE artistanome ILIKE ?"
               + "   )"
               + ")";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, "%" + titulo + "%");
    ps.setString(2, "%" + genero + "%");
    ps.setString(3, "%" + artista + "%");
    return ps.executeQuery();
}
}
