/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UsuarioDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import view.LoginFrame;

/**
 *
 * @author unifrcastanho
 */

public class ControllerLogin {
    private LoginFrame view;

    public ControllerLogin(LoginFrame view) {
        this.view = view;
    }
    
    public void loginUsuario(){
        Usuario user = new Usuario(null, 
                                view.getTxt_usuario_login().getText(),
                                view.getTxt_senha_login().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(user);
            if(res.next()){
                JOptionPane.showMessageDialog(view, 
                                              "Login efetuado!", 
                                              "Aviso",
                                              JOptionPane.INFORMATION_MESSAGE);
                Usuario aluno2 = new Usuario(res.getString("nome"), 
                                         res.getString("usuario"), 
                                         res.getString("senha"));
            } else{
                JOptionPane.showMessageDialog(view, 
                                              "Login NÃO efetuado!", 
                                              "Aviso",
                                              JOptionPane.ERROR_MESSAGE);
            }
        } catch(SQLException e){    
            JOptionPane.showMessageDialog(view, 
                                              "Erro de conexão!", 
                                              "Aviso",
                                              JOptionPane.ERROR_MESSAGE);
        }
    }
}
