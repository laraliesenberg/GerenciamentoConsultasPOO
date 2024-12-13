package br.com.gerenciamentoconsultas;

import java.util.Date;

/**
 *
 * @author lara
 * @author Eliézer 
 *
 */
public class Pessoa {
    private String nome;
    private long telefone;
    private long cpf;
    private Date dataNascimento;
    private Endereco endereco;

    public Pessoa(String nome, long telefone, long cpf, Date dataNascimento, Endereco endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return " Nome: " + nome + ", telefone: " + telefone ;
    }   
}
