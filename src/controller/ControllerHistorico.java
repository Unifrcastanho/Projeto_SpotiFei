/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.CurtidasDAO;
import DAO.DescurtidasDAO;
import DAO.HistoricoDAO;
import DAO.Conexao;
import view.HistoricoFrame;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
/**
 *
 * @author rodri
 */

public class ControllerHistorico {
    private HistoricoFrame view;
    private Connection conn;

    public ControllerHistorico(HistoricoFrame view) {
    this.view = view;
    this.conn = Conexao.getConexao();
    carregarListas();
}
    public void carregarListas() {
        try {
            // Curtidas
            CurtidasDAO curtidasDAO = new CurtidasDAO(conn);
            ResultSet rsCurtidas = curtidasDAO.listar();
            DefaultListModel<String> modelCurtidas = new DefaultListModel<>();
            while (rsCurtidas.next()) {
                modelCurtidas.addElement(rsCurtidas.getString("musictitulo"));
            }
            view.getList_curtidas().setModel(modelCurtidas);

            // Descurtidas
            DescurtidasDAO descurtidasDAO = new DescurtidasDAO(conn);
            ResultSet rsDescurtidas = descurtidasDAO.listar();
            DefaultListModel<String> modelDescurtidas = new DefaultListModel<>();
            while (rsDescurtidas.next()) {
                modelDescurtidas.addElement(rsDescurtidas.getString("musictitulo"));
            }
            view.getList_descurtidas().setModel(modelDescurtidas);

            // Histórico
            HistoricoDAO historicoDAO = new HistoricoDAO(conn);
            ResultSet rsHistorico = historicoDAO.listar();
            DefaultListModel<String> modelHistorico = new DefaultListModel<>();
            while (rsHistorico.next()) {
                modelHistorico.addElement(rsHistorico.getString("musictitulo"));
            }
            view.getList_historico().setModel(modelHistorico);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao carregar listas: " + e.getMessage());
        }
    }
}
