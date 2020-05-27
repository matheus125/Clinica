/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Medico;
import model.conexao.Conexao;

/**
 *
 * @author mathe
 */
public class MedicoDao {
    Conexao conex = new Conexao();
    
    public void Salvar(Medico med){
        conex.getConnection();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into medico (nome,crm,especialização,login,senha,email,endereco,tipo) values (?,?,?,?,?,?,?,?)");
            pst.setString(1, med.getNome());
            pst.setInt(2, med.getCrm());
            pst.setString(3, med.getEspecialização());
            pst.setString(4, med.getLogin());
            pst.setString(5, med.getSenha());
            pst.setString(6, med.getEmail());
            pst.setString(7, med.getEndereco());
            pst.setString(8, med.getTipo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastro Realizado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no Cadastro!/nErro!"+e.getMessage());
        }
        conex.desconecta();
    }
    public Medico buscarmedico(Medico med){
         conex.getConnection();
        conex.executaSql("select * from medico where nome like '%"+med.getPesquisa()+"%'");
        try {
            conex.rs.first();
            med.setID_medico(conex.rs.getInt("Id_medico"));
            med.setNome(conex.rs.getString("nome"));
            med.setCrm(conex.rs.getInt("crm"));
            med.setEspecialização(conex.rs.getString("especialização"));
            med.setLogin(conex.rs.getString("login"));
            med.setSenha(conex.rs.getString("senha"));
            med.setEmail(conex.rs.getString("email"));
            med.setEndereco(conex.rs.getString("endereco")); 
            med.setTipo(conex.rs.getString("tipo"));
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Médico não cadastrado");
        }
        conex.desconecta();
        return med;
    }
    public void Editar(Medico med){
        conex.getConnection();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update medico set nome=?,crm=?,especialização=?,login=?,senha=?,email=?,endereco=?,tipo=? where Id_medico=?" );
            pst.setString(1, med.getNome());
            pst.setInt(2, med.getCrm());
            pst.setString(3, med.getEspecialização());
            pst.setString(4, med.getLogin());
            pst.setString(5, med.getSenha());
            pst.setString(6, med.getEmail());
            pst.setString(7, med.getEndereco());
            pst.setString(8, med.getTipo());
            pst.setInt(9, med.getID_medico());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na alteração dos dados!/nErro:"+ex.getMessage());
        }
            
        conex.desconecta();
    }
    public void Excluir(Medico med){
         conex.getConnection();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from medico where Id_medico=?" );
            pst.setInt(1, med.getID_medico());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Excluidos!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir dados!/nErro"+e.getMessage());
        }
        conex.desconecta();
    }
}
