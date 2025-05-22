/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.Usuarios;
/**
 *
 * @author unifrcastanho
 */
public class UsuariosDAO {
    private Connection conn;

    public UsuariosDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Usuarios usuarios) throws SQLException{
        String sql = "select * from usuarios where userid = ? and usersenha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuarios.getUserid());
        statement.setString(2, usuarios.getUsersenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public void inserir(Usuarios usuarios) throws SQLException{
        String sql = "insert into usuarios (usernome, userid, usersenha) values ('"
                      + usuarios.getUsernome()    + "', '"
                      + usuarios.getUserid() + "', '"
                      + usuarios.getUsersenha()   + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
}
