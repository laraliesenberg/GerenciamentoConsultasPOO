/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gerenciamentoconsultas;

/**
 *
 * @author laral
 */
public class Consultorio {
	private String nomeLegal;
	private int cnpj;
	private Endereco endereco;

	public Consultorio(String nomeLegal, int cnpj, Endereco endereco) {
		this.nomeLegal = nomeLegal;
		this.cnpj = cnpj;
		this.endereco = endereco;
	}
	
	public Consultorio() {
		super();
	}

	public String getNomeLegal() {
		return nomeLegal;
	}

	public void setNomeLegal(String nomeLegal) {
		this.nomeLegal = nomeLegal;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return  "Nome Legal: " + nomeLegal + ", CNPJ: " + cnpj + ", Endereco: " + endereco;
	}

}
