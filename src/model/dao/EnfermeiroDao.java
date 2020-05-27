/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Enfermeiro;
import model.conexao.Conexao;

/**
 *
 * @author mathe
 */
public class EnfermeiroDao {
    Conexao conex = new Conexao();
    
    public void Salvar(Enfermeiro enfermeiro){
        conex.getConnection();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into enfermeiro (nome,especialização,login,senha,email,endereco,tipo) values (?,?,?,?,?,?,?)");
            pst.setString(1, enfermeiro.getNome());
            pst.setString(2, enfermeiro.getEspecialização());
            pst.setString(3, enfermeiro.getLogin());
            pst.setString(4, enfermeiro.getSenha());
            pst.setString(5, enfermeiro.getEmail());
            pst.setString(6, enfermeiro.getEndereco());
            pst.setString(7, enfermeiro.getTipo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastro Realizado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no Cadastro!/nErro!"+e.getMessage());
        }
        conex.desconecta();
    }
    public Enfermeiro buscarEnfermeiro(Enfermeiro enfermeiro){
        conex.getConnection();
        conex.executaSql("select * from enfermeiro where nome like '%"+enfermeiro.getPesquisar()+"%'");
        try {
            conex.rs.first();
            enfermeiro.setId_enfermeiro(conex.rs.getInt("Id_enfermeiro"));
            enfermeiro.setNome(conex.rs.getString("nome"));
            enfermeiro.setEspecialização(conex.rs.getString("especialização"));
            enfermeiro.setLogin(conex.rs.getString("login"));
            enfermeiro.setSenha(conex.rs.getString("senha"));
            enfermeiro.setEmail(conex.rs.getString("email"));
            enfermeiro.setEndereco(conex.rs.getString("endereco")); 
            enfermeiro.setTipo(conex.rs.getString("tipo"));
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Médico não cadastrado");
        }
        conex.desconecta();
        return enfermeiro;
    }
    public void Editar(Enfermeiro enfermeiro){
        conex.getConnection();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update enfermeiro set nome=?,especialização=?,login=?,senha=?,email=?,endereco=?,tipo=? where Id_enfermeiro=?" );
            pst.setString(1, enfermeiro.getNome());
            pst.setString(2, enfermeiro.getEspecialização());
            pst.setString(3, enfermeiro.getLogin());
            pst.setString(4, enfermeiro.getSenha());
            pst.setString(5, enfermeiro.getEmail());
            pst.setString(6, enfermeiro.getEndereco());
            pst.setString(7, enfermeiro.getTipo());
            pst.setInt(8, enfermeiro.getId_enfermeiro());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na alteração dos dados!/nErro:"+ex.getMessage());
        }
            
        conex.desconecta();
    }
    public void Excluir(Enfermeiro enfermeiro){
        conex.getConnection();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from enfermeiro where Id_enfermeiro=?" );
            pst.setInt(1, enfermeiro.getId_enfermeiro());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Excluidos!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir dados!/nErro"+e.getMessage());
        }
        conex.desconecta();
    }
    
}
