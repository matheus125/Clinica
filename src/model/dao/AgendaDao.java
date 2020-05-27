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
import model.conexao.Conexao;
import model.bean.AgendaConsulta;
/**
 *
 * @author Vaio
 */
public class AgendaDao {
    AgendaConsulta agenda = new AgendaConsulta();
    Conexao conex = new Conexao();
    Conexao conexPaciente = new Conexao();
    Conexao conexMedico = new Conexao();

    int codMedico;
    int codPaciente;

public void salvar(AgendaConsulta agenda){
    
    BuscarMedico(agenda.getNomeMedico());
    BuscarPaciente(agenda.getNomePaciente());
    
    Conexao.getConnection();
        try {
            PreparedStatement pst = Conexao.con.prepareStatement("insert into agendamento(Id_paciente, agenda_turno, Id_medico, agenda_data, agenda_motivo, agenda_status)values(?,?,?,?,?,?)");
            pst.setInt(1, codPaciente);
            pst.setString(2, agenda.getTurno());
            pst.setInt(3, codMedico);
            pst.setDate(4, new java.sql.Date(agenda.getData().getTime()));
            pst.setString(5, agenda.getMotivo());
            pst.setString(6, agenda.getStatus());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Agendamendo salvo com sucesso!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar agendamento!"+ex);
        }
    
    conex.desconecta();
}
    
public void BuscarMedico(String nomeMedico){
    Conexao.getConnection();
    conexMedico.executaSql("select * from medico where nome like '%"+nomeMedico+"%'");
        try {
            conexMedico.rs.first();
            codMedico = conexMedico.rs.getInt("Id_medico");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Médico não encontrado!");
        }
        conex.desconecta();
    }

public int BuscaCodMedico(String nomeMedico){
    Conexao.getConnection();
    conexMedico.executaSql("select * from medico where nome like '%"+nomeMedico+"%'");
        try {
            conexMedico.rs.first();
            codMedico = conexMedico.rs.getInt("Id_medico");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Médico não encontrado!");
        }
        return codMedico;
    }

public void BuscarPaciente(String nomePaciente){
    Conexao.getConnection();
    conexPaciente.executaSql("select * from paciente where nome like '%"+nomePaciente+"%'");
        try {
            conexPaciente.rs.first();
            codPaciente = conexPaciente.rs.getInt("Id_paciente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Paciente não encontrado!");
        }
        conex.desconecta();
    }
public void Alterar (AgendaConsulta agenda){
    Conexao.getConnection();
    
        try {
            PreparedStatement pst = Conexao.con.prepareStatement("update agendamento set agendamento.agenda_status=? where agendamento.agenda_cod=?" );
            pst.setString(1, agenda.getStatus());
            pst.setInt(2, agenda.getAgendaCod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Agendamento em atendimento");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro no atendimento!/nErro:"+ex.getMessage());
        }
        conex.desconecta();
}
public AgendaConsulta BuscarAgenda(int cod){
    AgendaConsulta agen = new AgendaConsulta();
    Conexao.getConnection();
    conex.executaSql("select * from agendamento inner join paciente on agendamento.ID_paciente = paciente.Id_paciente inner join medico on agendamento.Id_medico = medico.Id_medico where agendamento.agenda_cod ='"+cod+"'");
        try {
            conex.rs.first();
            agen.setNomePaciente(conex.rs.getString("paciente.nome"));
            agen.setNomeMedico(conex.rs.getString("medico.nome"));
            agen.setMotivo(conex.rs.getString("agendamento.agenda_motivo"));
            agen.setPacienteNasc(conex.rs.getString("paciente.nascimento"));
         } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Agendamento/n"+e);
        }
        return agen;
}
}