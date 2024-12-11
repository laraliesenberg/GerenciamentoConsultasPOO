
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
		g.setarObjetoPaciente();
		g.setarObjetoMedico();
		g.setarObjetoConsulta();
		while (opcao >= 1 && opcao <= 8) {
			try {
				opcao = menu(); // Chama o menu para obter a opção
			} catch (InputMismatchException e) {
				System.out.println("Erro: Entrada errada");
				opcao = 7;
			}
			switch (opcao) {
			case 1:
				Paciente p = g.setarPaciente();
				if (p != null) {
					g.cadastrarPaciente(p);
				} else {
					System.out.println("Ocorreu um erro");
				}

				break;
			case 2:
				Medico m = g.setarMedico();
				if (m != null) {
					g.cadastrarMedico(m);
				} else {
					System.out.println("Ocorreu um erro");
				}
				break;
			case 3:
				Consulta c = g.setarConsulta();
				if(c != null) {
					g.cadastrarConsulta(c);
				} else {
					System.out.println("Ocorreu um erro");
				}
				break;
			case 4:
				g.confirmarPresenca();
				break;
			case 5:
				g.setarDiagnostico();
				break;
			case 6:
				g.listarConsultasPaciente();
				break;
			case 7:
				g.listarPacientes();
				break;
			case 8:
				g.listarMedicos();
				break;
			default:
				System.out.println("Opção Inválida");
			}
		}
	}
	public static int menu() {
		Scanner s = new Scanner(System.in);
		System.out.println("----------------------------------");
		System.out.println("1- Cadastrar paciente");
		System.out.println("2- Cadastrar médico");
		System.out.println("3- Cadastrar consulta");
		System.out.println("4- Registrar presença");
		System.out.println("5- Inserir diagnóstico");
		System.out.println("6- Listar consultas do paciente");
		System.out.println("7- Listar Pacientes");
		System.out.println("8- Listar Médicos");
		System.out.println("9- Sair ");
		System.out.println("----------------------------------");
		int opcao = s.nextInt();
		s.nextLine();
		return opcao;
	}
}
