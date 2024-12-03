/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.gerenciamentoconsultas;

import java.util.LinkedList;

/**
 *
 * @author laral
 */
public interface CrudGerenciamento {
    public void cadastrarPaciente(Paciente p);
    public void cadastrarMedico(Medico m);
    public void cadastrarConsulta(Consulta c);
    public void alterarDadosPacienet(Paciente p);
    public void alterarDadosMedico(Medico m);
    public void alterarDadosConsulta(Consulta c);
    public void listarConsultasPaciente(LinkedList<Consulta>listconsulta);
}
