/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Historico;

/**
 *
 * @author unifrcastanho
 */
public class HistoricoDAO {
     private Connection conn;

    public HistoricoDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Historico historico) throws SQLException{
        String sql = "select * from historico ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, historico.getMusicid());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
}
