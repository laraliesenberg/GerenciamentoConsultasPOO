/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gerenciamentoconsultas;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author laral
 */
public class Consulta {
    private Medico medico;
    private Paciente paciente;
    private LocalDateTime horarioEdata;
    private String diagnostico;
    private boolean situacaoConsulta = false;
    private Consultorio consultorio;

    public Consulta(Medico medico, Paciente paciente, LocalDateTime horarioEdata, String diagnostico, Consultorio consultorio) {
        this.medico = medico;
        this.paciente = paciente;
        this.horarioEdata = horarioEdata;
        this.diagnostico = diagnostico;
        this.consultorio = consultorio;
    }

    public Consulta() {
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getHorarioEdata() {
        return horarioEdata;
    }

    public void setHorarioEdata(LocalDateTime dateTime) {
        this.horarioEdata = dateTime;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public boolean isSituacaoConsulta() {
        return situacaoConsulta;
    }

    public void setSituacaoConsulta(boolean situacaoConsulta) {
        this.situacaoConsulta = situacaoConsulta;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    @Override
    public String toString() {
        return "CONSULTA: "  + medico + "PACIENTE: " + paciente + "Horário da consulta: " + horarioEdata + "\nDIAGNÓSTICO: " + diagnostico + ", situação da consulta: " + situacaoConsulta + "\nCONSULTÓRIO:  " + consultorio ;
    }    
}
