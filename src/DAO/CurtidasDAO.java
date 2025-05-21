/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Curtidas;

/**
 *
 * @author unifrcastanho
 */
public class CurtidasDAO {
     private Connection conn;

    public CurtidasDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Curtidas curtidas) throws SQLException{
        String sql = "select * from curtidas ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, curtidas.getMusicid());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
}
