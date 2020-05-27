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
import model.bean.Paciente;
import model.conexao.Conexao;




public class PacienteDao {
 
    Conexao conex = new Conexao();
    Conexao conexaoBairro = new Conexao();
    Paciente paciente = new Paciente();
    String nomeBairro;
    int codBai;
    
    public void Salvar(Paciente pac){
        buscarBaicod(pac.getNomebairro());
        conex.getConnection();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into paciente (nome,nascimento,rg,telefone,rua,cep,complemento,Id_bairro) values (?,?,?,?,?,?,?,?)");
            pst.setString(1, pac.getNome());
            pst.setString(2, pac.getNascimento());
            pst.setString(3, pac.getRg());
            pst.setString(4, pac.getTelefone());
            pst.setString(5, pac.getRua());
            pst.setString(6, pac.getCep());
            pst.setString(7, pac.getComplemento());
            pst.setInt(8, codBai);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Paciente Salvo com Sucesso!");
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Salvar Dados!"+ex.getMessage());
        }
        conex.desconecta();
    }
       
    public void buscarBaicod(String nome){
    conex.getConnection();
    conex.executaSql("select * from bairro where nomebairro = '"+nome+"'");
    
        try {
            conex.rs.first();
            codBai=conex.rs.getInt("Id_bairro");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar bairro"+ex.getMessage());
        }
     conex.desconecta();
    }
    
    public Paciente buscarPaciente(Paciente pac){
    conex.getConnection();
        try {
            conex.executaSql("select * from paciente where nome like '%"+pac.getPesquisar()+"%'");
            conex.rs.first();
            buscarnomeBairro(conex.rs.getInt("Id_bairro"));
            pac.setId_paciente(conex.rs.getInt("Id_paciente"));
            pac.setNome(conex.rs.getString("nome"));
            pac.setNascimento(conex.rs.getString("nascimento"));
            pac.setRg(conex.rs.getString("rg"));
            pac.setTelefone(conex.rs.getString("telefone"));
            pac.setRua(conex.rs.getString("rua"));
            pac.setCep(conex.rs.getString("cep"));
            pac.setComplemento(conex.rs.getString("complemento"));
            pac.setNomebairro(nomeBairro);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Pacientes"+ex.getMessage());
        }
     conex.desconecta();
     return pac;
    }
  
    
    public void buscarnomeBairro(int cod){
        conex.getConnection();
        try {
            conexaoBairro.executaSql("select * from bairro where Id_bairro="+cod);
            conexaoBairro.rs.first();
            nomeBairro = conexaoBairro.rs.getString("nomebairro");
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Buscar Nome do Bairro"+ex.getMessage());
        }
        conexaoBairro.desconecta();
    }
    
    public void Editar(Paciente pac){
        buscarBaicod(pac.getNomebairro());
        conex.getConnection();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update paciente set nome=?,nascimento=?,rg=?,telefone=?,rua=?,cep=?,complemento=?,Id_bairro=? where Id_paciente=?");
            pst.setString(1, pac.getNome());
            pst.setString(2, pac.getNascimento());
            pst.setString(3, pac.getRg());
            pst.setString(4, pac.getTelefone());
            pst.setString(5, pac.getRua());
            pst.setString(6, pac.getCep());
            pst.setString(7, pac.getComplemento());
            pst.setInt(8, codBai);
            pst.setInt(9, pac.getId_paciente());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Paciente Alterado com Sucesso!");
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Alterar Paciente!"+ex.getMessage());
        }
        conex.desconecta();
    }
    
}
