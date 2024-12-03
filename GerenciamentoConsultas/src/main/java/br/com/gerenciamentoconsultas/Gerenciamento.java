
package br.com.gerenciamentoconsultas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author laral
 */
public class Gerenciamento implements CrudGerenciamento {
	private LinkedList<Paciente> listPacientes = new LinkedList<Paciente>();
	private LinkedList<Medico> listMedicos = new LinkedList<Medico>();
	private LinkedList<Consulta> listConsultas = new LinkedList<Consulta>();

	Scanner s = new Scanner(System.in);
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

	public Gerenciamento() {
	}

	public void cadastrarPaciente(Paciente p) {
		listPacientes.add(p);

	}

	public void cadastrarMedico(Medico m) {
		listMedicos.add(m);
		
	}

	public void cadastrarConsulta(Consulta c) {
		listConsultas.add(c);
	}


	public Endereco setarEndereco() {
		Endereco endereco = new Endereco();
		System.out.print("Rua : ");
		endereco.setRua(s.nextLine());
		System.out.println("Bairro : ");
		endereco.setBairro(s.nextLine());
		System.out.println("Estado : ");
		endereco.setEstado(s.nextLine());
		System.out.println("Cidade : ");
		endereco.setCidade(s.nextLine());
		System.out.println("Cep :");
		endereco.setCep(s.nextInt());
		System.out.println("Numero Residencia:");
		endereco.setNumero(s.nextInt());
		return endereco;
	}

	public Pessoa setarPessoa() {
		Paciente p = new Paciente();
		System.out.print("Nome: ");
		p.setNome(s.nextLine());
		System.out.println("Telefone: ");
		p.setTelefone(s.nextInt());
		System.out.println("CPF:");
		p.setCpf(s.nextInt());
		System.out.println("Data De nascimento XX/XX/XXXX");
		String dataNasc = s.nextLine();
		try {
			p.setDataNascimento(format.parse(dataNasc));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Data de nascimento errada");
		}
		p.setEndereco(setarEndereco());
		return p;
	}

	public Paciente setarPaciente() {
		Paciente paciente = new Paciente();
		Pessoa pessoa = new Pessoa();
		paciente.setCpf(pessoa.getCpf());
		paciente.setDataNascimento(pessoa.getDataNascimento());
		paciente.setNome(pessoa.getNome());
		paciente.setTelefone(pessoa.getTelefone());
		pessoa = setarPessoa();

		System.out.println("Convenio");
		paciente.setConvenio(s.nextLine());

		return paciente;
	}

	public Consulta setarConsulta() {
		Consulta consulta = new Consulta();
		System.out.println("Data De nascimento XX/XX/XXXX HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(s.nextLine(), formatter);
		consulta.setConsultorio(setarConsultorio());
		System.out.println("CPF do paciente");
		int cpf = s.nextInt();
		for (Paciente p : listPacientes) {
			if (p.getCpf() == cpf) {
				consulta.setPaciente(p);
			} else {
				System.out.println("Paciente Não Cadastrado");
				return null;
			}
		}
		System.out.println("CRM do Medico");
		int crm = s.nextInt();
		for (Medico m : listMedicos) {
			if (m.getCrm() == crm) {
				consulta.setMedico(m);
			} else {
				System.out.println("Medico Não Cadastrado");
				return null;
			}
		}

		return null;
	}

	public Medico setarMedico() {
		Medico medico = new Medico();
		Pessoa pessoa = new Pessoa();
		pessoa = setarPessoa();
		medico.setCpf(pessoa.getCpf());
		medico.setDataNascimento(pessoa.getDataNascimento());
		medico.setNome(pessoa.getNome());
		medico.setTelefone(pessoa.getTelefone());
		medico.setEndereco(setarEndereco());
		System.out.println("Especialização :");
		medico.setEspecializacao(s.nextLine());
		System.out.println("Email");
		medico.setEmail(s.nextLine());
		System.out.println("CRM :");
		medico.setCrm(s.nextInt());

		return medico;

	}

	public int menu() {
		System.out.println("----------------------------------");
		System.out.println("1- Cadastrar paciente");
		System.out.println("2- Cadastrar médico");
		System.out.println("3- Cadastrar consulta");
		System.out.println("4- Confirmar consulta");
		System.out.println("5- Inserir diagnostico");
		System.out.println("6- Listar consultas do paciente");
		System.out.println("7- Sair \n");
		System.out.println("----------------------------------");
		int opcao = s.nextInt();
		s.nextLine();
		return opcao;
	}

	public Consultorio setarConsultorio() {
		Consultorio consultorio = new Consultorio();
		System.out.println("Nome legal :");
		consultorio.setNomeLegal(s.nextLine());
		System.out.println("CNPJ :");
		consultorio.setCnpj(s.nextInt());
		consultorio.setEndereco(setarEndereco());

		return consultorio;
	}

	public void confirmarPresenca() {
		System.out.println("CPF:");
		int cpf = s.nextInt();
		for (Consulta consulta : listConsultas) {
			if (consulta.getPaciente().getCpf() == cpf) {
				consulta.setSituacaoConsulta(true);
			} else {
				System.out.println("Não ha consulta");
			}

		}

	}

	public void setarDiagnostico() {
		System.out.println("CPF:");
		int cpf = s.nextInt();
		for (int i = 0; i < listConsultas.size(); i++) {
			Consulta consulta = listConsultas.get(i);
			if (consulta.getPaciente().getCpf() == cpf) {
				System.out.println("Posição: " + i + " | Data da consulta: " + consulta.getHorarioEdata());
			}
		}
		System.out.println("Informe qual consulta voce quer alterar");
		int opcao = s.nextInt();
		int i = 0;
		for (Consulta consulta : listConsultas) {
			if(opcao==i) {
				System.out.println("Diagnostico : ");
				consulta.setDiagnostico(s.nextLine());
			}
		}
	}

	

	public void listarConsultasPaciente() {
		System.out.println("CPF:");
		int cpf = s.nextInt();
		for (Consulta consulta : listConsultas) {
			if (consulta.getPaciente().getCpf() == cpf) {
				System.out.println(consulta);
			} else {
				System.out.println("Não ha consulta");
			}

		}
	}
}
