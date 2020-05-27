/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author mathe
 */
public class Conexao {
    public Statement stm;
    public ResultSet rs;
    
    private static final String caminho = "jdbc:mysql://localhost:3306/clinica";
    private static final String usuario = "root";
    private static final String senha = "root123";
    public static Connection con;

    public static Connection getConnection() {
        try {
            con=DriverManager.getConnection(caminho,usuario,senha);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao se conectar com o banco de dados:\n"+e.getMessage());
        }
        return con;
    }
    public void executaSql(String sql){
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Executar Sql:\n"+e.getMessage());
        }
    }

    public void desconecta() {
         try {
          con.close();
      } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao fechar cenexao com bd:\n"+ex.getMessage());
      }
    }
}
