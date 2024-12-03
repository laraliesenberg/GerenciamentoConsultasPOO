
package br.com.gerenciamentoconsultas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author laral
 */
public class GerenciamentoConsultas {

    public static void main(String[] args) {
        Gerenciamento g = new Gerenciamento();
       
        
        int opcao = 1;
        
        while(opcao >= 1 && opcao <= 6){
        	 try {
                 opcao = g.menu();  // Chama o menu para obter a opção
             } catch (InputMismatchException e) {
                 System.out.println("Erro: Entrada errada");   
                 opcao = 7;
             }            
            switch(opcao){
                case 1:
                	Paciente p = g.setarPaciente();			                    
                    g.cadastrarPaciente(p);
                    break;
                case 2:
                	Medico m = g.setarMedico();
                	g.cadastrarMedico(m);
                	break;
                case 3:
                	Consulta c = g.setarConsulta();
                	g.cadastrarConsulta(c);
                	break;
                case 4:
                	g.confirmarPresenca();
                	break;
                case 5:
                	g.setarDiagnostico();
                	break;
                case 6: 
                	g.listarConsultasPaciente();
                case 7:
                	break;
                default: 
                	System.out.println("Opição Inválida");
            }
        }
    }
}
