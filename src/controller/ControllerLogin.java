/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import DAO.UsuariosDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuarios;
import view.LoginFrame;
import view.SpotifeiFrame;

/**
 *
 * @author unifrcastanho
 */
public class ControllerLogin {
    private LoginFrame view;

    public ControllerLogin(LoginFrame view) {
        this.view = view;
    }
    
    
    public void abrirSpotifei() {
        new SpotifeiFrame().setVisible(true);
        view.dispose();
    }
    
    public void loginUsuarios() {
        // 1) Captura os dados da view
        Usuarios usuarios = new Usuarios(
            null,
            view.getTxt_id_login().getText(),
            view.getTxt_senha_login().getText()
        );

        // 2) Abre a conexão
        Connection conn = null;
        try {
            conn = Conexao.getConexao();             // <<— use o método estático, em vez de instanciar Conexao
            UsuariosDAO dao = new UsuariosDAO(conn);

            // 3) Executa a consulta
            ResultSet res = dao.consultar(usuarios);

            // 4) Verifica se veio algum resultado
            if (res.next()) {
                JOptionPane.showMessageDialog(view,
                    "Login efetuado!",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
                // Aqui você pode avançar para a próxima tela, ex:
                // new SpotifeiFrame().setVisible(true);
                // view.dispose();
            } else {
                JOptionPane.showMessageDialog(view,
                    "ID ou senha incorretos.",
                    "Erro de autenticação",
                    JOptionPane.ERROR_MESSAGE);
            }

            // 5) Fechar ResultSet e DAO se necessário
            res.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view,
                "Erro de conexão: " + e.getMessage(),
                "Aviso",
                JOptionPane.ERROR_MESSAGE);
        } finally {
            // 6) Fecha a conexão
            if (conn != null) {
                try { conn.close(); }
                catch (SQLException ignored) {}
            }
        }
    }
}
