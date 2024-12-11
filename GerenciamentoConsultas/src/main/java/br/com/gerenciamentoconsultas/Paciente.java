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
   
    private String convenio;

    public Paciente(String convenio, String nome, long telefone, long cpf, Date dataNascimento, Endereco endereco) {
        super(nome, telefone, cpf, dataNascimento, endereco);
       
        this.convenio = convenio;
    }

    public Paciente( String convenio) {
        
        this.convenio = convenio;
    }

    public Paciente() {
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    @Override
    public String toString() {
        return  super.toString() + " CPF: "+super.getCpf() + ", convenio: " + convenio + " \nENDEREÇO: " + super.getEndereco() ;
    }
    
}
