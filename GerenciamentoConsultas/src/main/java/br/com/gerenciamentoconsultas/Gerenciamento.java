/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gerenciamentoconsultas;

import java.util.LinkedList;

/**
 *
 * @author laral
 */
public class Gerenciamento implements CrudGerenciamento{
    private LinkedList<Paciente> listPacientes = new LinkedList<Paciente>();
    private LinkedList<Medico> listMedicos = new LinkedList<Medico>();
    private LinkedList<Consulta> listConsultas = new LinkedList<Consulta>();

    @Override
    public void cadastrarPaciente(Paciente p) {
    }

    @Override
    public void cadastrarMedico(Medico m) {
    }

    @Override
    public void cadastrarConsulta(Consulta c) {
    }

    @Override
    public void alterarDadosPacienet(Paciente p) {
    }

    @Override
    public void alterarDadosMedico(Medico m) {
    }

    @Override
    public void alterarDadosConsulta(Consulta c) {
    }

    public Gerenciamento(){
    }
    
}
