/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Descurtidas;

/**
 *
 * @author unifrcastanho
 */
public class DescurtidasDAO {
    private Connection conn;

    public DescurtidasDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Descurtidas descurtidas) throws SQLException{
        String sql = "select * from descurtidas ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, descurtidas.getMusicid());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
}
