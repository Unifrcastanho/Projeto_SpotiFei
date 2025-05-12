/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author unifrcastanho
 */

public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Usuario user) throws SQLException{
        String sql = "select * from usuarios where id = ? and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, user.getId());
        statement.setString(2, user.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public void inserir(Usuario user) throws SQLException{
        String sql = "insert into usuarios (nome, id, senha) values ('"
                      + user.getNome()    + "', '"
                      + user.getId() + "', '"
                      + user.getSenha()   + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
}