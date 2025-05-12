/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UsuarioDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import view.CadastroFrame;

/**
 *
 * @author unifrcastanho
 */

public class ControllerCadastro {
    private CadastroFrame view;
    
    public ControllerCadastro(CadastroFrame view){
        this.view = view;
    }
    
    public void salvarAluno(){
        String nome = view.getTxt_nome_cadastro().getText();
        String usuario = view.getTxt_usuario_cadastro().getText();
        String senha = view.getTxt_senha_cadastro().getText();
        Usuario user = new Usuario(nome, usuario,senha);
        
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.inserir(user);
            JOptionPane.showMessageDialog(view, "Usuario Cadastrado!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Usuário não cadastrado!","Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
