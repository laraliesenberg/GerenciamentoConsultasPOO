
package br.com.gerenciamentoconsultas;

import java.util.LinkedList;

public interface CrudGerenciamento {
    public void cadastrarPaciente(Paciente p);
    public void cadastrarMedico(Medico m);
    public void cadastrarConsulta(Consulta c);
    public void setarDiagnostico();
    public boolean confirmarPresenca();
    public void listarConsultasPaciente();
}
