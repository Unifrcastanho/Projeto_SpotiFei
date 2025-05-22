/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.UsuariosDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuarios;
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
    
    public void salvarUsuarios(){
        String nome = view.getTxt_nome_cadastro().getText();
        String id = view.getTxt_id_cadastro().getText();
        String senha = view.getTxt_senha_cadastro().getText();
        Usuarios usuarios = new Usuarios(nome, id,senha);
        
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConexao();
            UsuariosDAO dao = new UsuariosDAO(conn);
            dao.inserir(usuarios);
            JOptionPane.showMessageDialog(view, "Usuario Cadastrado!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Usuário não cadastrado!","Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
