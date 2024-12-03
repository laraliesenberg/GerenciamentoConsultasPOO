/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gerenciamentoconsultas;

import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author laral
 */
public class Paciente extends Pessoa {
    private LinkedList<Consulta> historicoConsultas;
    private String convenio;

    public Paciente(LinkedList<Consulta> historicoConsultas, String convenio, String nome, int telefone, int cpf, Date dataNascimento, Endereco endereco) {
        super(nome, telefone, cpf, dataNascimento, endereco);
        this.historicoConsultas = historicoConsultas;
        this.convenio = convenio;
    }

    public Paciente(LinkedList<Consulta> historicoConsultas, String convenio) {
        this.historicoConsultas = historicoConsultas;
        this.convenio = convenio;
    }

    public Paciente() {
    }

    public LinkedList<Consulta> getHistoricoConsultas() {
        return historicoConsultas;
    }

    public void setHistoricoConsultas(LinkedList<Consulta> historicoConsultas) {
        this.historicoConsultas = historicoConsultas;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    @Override
    public String toString() {
        return "Paciente{" + "historicoConsultas=" + historicoConsultas + ", convenio=" + convenio + '}';
    }
    
}
