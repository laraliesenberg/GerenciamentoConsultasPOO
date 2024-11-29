/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gerenciamentoconsultas;

import java.util.Date;

/**
 *
 * @author laral
 */
public class Medico extends Pessoa{
    private String especializacao;
    private int crm;
    private String email;

    public Medico(String especializacao, int crm, String email, String nome, int telefone, int cpf, Date dataNascimento, Endereco endereco) {
        super(nome, telefone, cpf, dataNascimento, endereco);
        this.especializacao = especializacao;
        this.crm = crm;
        this.email = email;
    }

    public Medico(String especializacao, int crm, String email) {
        this.especializacao = especializacao;
        this.crm = crm;
        this.email = email;
    }

    public Medico() {
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
