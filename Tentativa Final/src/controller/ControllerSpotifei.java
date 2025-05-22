/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.CurtidasDAO;
import DAO.DescurtidasDAO;
import DAO.MusicasDAO;
import DAO.Conexao;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.SpotifeiFrame;
import view.HistoricoFrame;
import view.PlaylistFrame;

/**
 *
 * @author unifrcastanho
 */

public class ControllerSpotifei {
    private final SpotifeiFrame view;
    private final Connection conn;
    private final MusicasDAO musicasDAO;
    private final CurtidasDAO curtidasDAO;
    private final DescurtidasDAO descurtidasDAO;

    public ControllerSpotifei(SpotifeiFrame view) {
        this.view = view;
        this.conn = Conexao.getConexao();
        this.musicasDAO    = new MusicasDAO(conn);
        this.curtidasDAO   = new CurtidasDAO(conn);
        this.descurtidasDAO = new DescurtidasDAO(conn);
        bindActions();
    }

    private void bindActions() {
        view.getBt_buscar_musica().addActionListener(e -> buscarMusicas());
        view.getBt_curtir_playlist().addActionListener(e -> curtirMusica());
        view.getBt_descurtir_playlist().addActionListener(e -> descurtirMusica());
        view.getBt_historico().addActionListener(e -> abrirHistorico());
        view.getBt_playlist().addActionListener(e -> abrirPlaylists());
    }

    public void buscarMusicas() {
        String titulo  = view.getTxt_titulo_buscar().getText().trim();
        String artista = view.getTxt_artista_buscar().getText().trim();
        String genero  = view.getTxt_genero_buscar().getText().trim();

        try {
            // Você precisa implementar este método no MusicasDAO
            ResultSet rs = musicasDAO.buscarPorFiltros(titulo, artista, genero);
            popularTabela(rs, view.getTable_buscar_musicas());
        } catch (SQLException ex) {
    JOptionPane.showMessageDialog(view,
        "Erro ao buscar músicas: " + ex.getMessage(),
        "Erro de Banco", JOptionPane.ERROR_MESSAGE);
}
    }

    public void curtirMusica() {
    JTable tabela = view.getTable_buscar_musicas();
    int linha = tabela.getSelectedRow();
    if (linha == -1) return;

    String titulo = (String) tabela.getValueAt(linha, 1);
    try {
        boolean ok = curtidasDAO.adicionarCurtida(titulo);
        if (!ok) {
            JOptionPane.showMessageDialog(view, "Não foi possível curtir a música.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(view, "Erro ao curtir música: " + ex.getMessage());
    }
}

public void descurtirMusica() {
    JTable tabela = view.getTable_buscar_musicas();
    int linha = tabela.getSelectedRow();
    if (linha == -1) return;

    String titulo = (String) tabela.getValueAt(linha, 1);
    try {
        boolean ok = descurtidasDAO.adicionarDescurtida(titulo);
        if (!ok) {
            JOptionPane.showMessageDialog(view, "Não foi possível descurtir a música.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(view, "Erro ao descurtir música: " + ex.getMessage());
    }
}

    public void abrirHistorico() {
        new HistoricoFrame().setVisible(true);
        view.dispose();
    }

    public void abrirPlaylists() {
        new PlaylistFrame().setVisible(true);
        view.dispose();
    }

    public void popularTabela(ResultSet rs, JTable table) throws SQLException {
        DefaultTableModel model = new DefaultTableModel(
            new Object[]{"ID", "Título", "Gênero"}, 0
        );
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("musicid"),
                rs.getString("musictitulo"),
                rs.getString("musicgenero")
            });
        }
        table.setModel(model);
    }
}
