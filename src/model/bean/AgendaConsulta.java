/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.Date;

/**
 *
 * @author Vaio
 */
public class AgendaConsulta {
    private int agendaCod;
    private String nomeMedico;
    private String nomePaciente;
    private String turno;
    private Date data;
    private String status;
    private String motivo;
    private String pesquisar;
    private String pacienteNasc;

    /**
     * @return the agendaCod
     */
    public int getAgendaCod() {
        return agendaCod;
    }

    /**
     * @param agendaCod the agendaCod to set
     */
    public void setAgendaCod(int agendaCod) {
        this.agendaCod = agendaCod;
    }

    /**
     * @return the nomeMedico
     */
    public String getNomeMedico() {
        return nomeMedico;
    }

    /**
     * @param nomeMedico the nomeMedico to set
     */
    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    /**
     * @return the nomeMaciente
     */
    public String getNomePaciente() {
        return nomePaciente;
    }

    /**
     * @param nomeMaciente the nomeMaciente to set
     */
    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    /**
     * @return the turno
     */
    public String getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(String turno) {
        this.turno = turno;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * @return the pesquisar
     */
    public String getPesquisar() {
        return pesquisar;
    }

    /**
     * @param pesquisar the pesquisar to set
     */
    public void setPesquisar(String pesquisar) {
        this.pesquisar = pesquisar;
    }

    /**
     * @return the pacienteNasc
     */
    public String getPacienteNasc() {
        return pacienteNasc;
    }

    /**
     * @param pacienteNasc the pacienteNasc to set
     */
    public void setPacienteNasc(String pacienteNasc) {
        this.pacienteNasc = pacienteNasc;
    }
}
