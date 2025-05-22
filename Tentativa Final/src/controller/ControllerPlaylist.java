/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import view.PlaylistFrame;
import java.sql.SQLException;
import DAO.Conexao;
/**
 *
 * @author rodri
 */
public class ControllerPlaylist {
    private PlaylistFrame view;
    private Connection conn; 

     public ControllerPlaylist(PlaylistFrame view){
        this.view = view;
        this.conn = Conexao.getConexao();
    }
       
     
     
    public void criarPlaylist() {
        try {
            String nome = view.getTxt_playlist().getText();
            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Digite o nome da playlist.");
                return;
            }

            String sql = "INSERT INTO playlists (playlistnome) VALUES (?)";
            var ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(view, "Playlist criada com sucesso.");
            atualizarListaPlaylists();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao criar playlist: " + e.getMessage());
        }
    }

    public void excluirPlaylist() {
        try {
            String nome = view.getTxt_playlist().getText();
            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Digite o nome da playlist.");
                return;
            }

            String sql = "DELETE FROM playlists WHERE playlistnome = ?";
            var ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(view, "Playlist excluída.");
                atualizarListaPlaylists();
            } else {
                JOptionPane.showMessageDialog(view, "Playlist não encontrada.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao excluir playlist: " + e.getMessage());
        }
    }

    public void mostrarMusicasPlaylist() {
        try {
            String playlistNome = view.getTxt_playlist_add_remove().getText();
            if (playlistNome.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Digite o nome da playlist.");
                return;
            }

            String sql = "SELECT musicatitulo FROM musicas m " +
                         "JOIN playlist_musicas pm ON m.musicid = pm.musicid " +
                         "JOIN playlists p ON pm.playlistid = p.playlistid " +
                         "WHERE p.playlistnome = ?";
            var ps = conn.prepareStatement(sql);
            ps.setString(1, playlistNome);
            ResultSet rs = ps.executeQuery();

            DefaultListModel<String> model = new DefaultListModel<>();
            while (rs.next()) {
                model.addElement(rs.getString("musicatitulo"));
            }
            view.getList_musicas_playlist().setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao carregar músicas: " + e.getMessage());
        }
    }

    public void adicionarMusica() {
        try {
            String playlistNome = view.getTxt_playlist_add_remove().getText();
            String tituloMusica = view.getTxt_titulo_add_remove().getText();

            if (playlistNome.isEmpty() || tituloMusica.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Preencha os campos playlist e título.");
                return;
            }

            String sql = "INSERT INTO playlist_musicas (playlistid, musicid) " +
                         "SELECT p.playlistid, m.musicid FROM playlists p, musicas m " +
                         "WHERE p.playlistnome = ? AND m.musicatitulo = ?";
            var ps = conn.prepareStatement(sql);
            ps.setString(1, playlistNome);
            ps.setString(2, tituloMusica);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(view, "Música adicionada.");
                mostrarMusicasPlaylist();
            } else {
                JOptionPane.showMessageDialog(view, "Playlist ou música não encontrada.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao adicionar música: " + e.getMessage());
        }
    }

    public void removerMusica() {
        try {
            String playlistNome = view.getTxt_playlist_add_remove().getText();
            String tituloMusica = view.getTxt_titulo_add_remove().getText();

            if (playlistNome.isEmpty() || tituloMusica.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Preencha os campos playlist e título.");
                return;
            }

            String sql = "DELETE FROM playlist_musicas " +
                         "WHERE playlistid = (SELECT playlistid FROM playlists WHERE playlistnome = ?) " +
                         "AND musicid = (SELECT musicid FROM musicas WHERE musicatitulo = ?)";
            var ps = conn.prepareStatement(sql);
            ps.setString(1, playlistNome);
            ps.setString(2, tituloMusica);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(view, "Música removida.");
                mostrarMusicasPlaylist();
            } else {
                JOptionPane.showMessageDialog(view, "Associação não encontrada.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao remover música: " + e.getMessage());
        }
    }

    public void atualizarListaPlaylists() {
        try {
            String sql = "SELECT playlistnome FROM playlists";
            var ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            DefaultListModel<String> model = new DefaultListModel<>();
            while (rs.next()) {
                model.addElement(rs.getString("playlistnome"));
            }

            view.getList_playlist1().setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao carregar playlists: " + e.getMessage());
        }
    }
}
