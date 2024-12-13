package br.com.gerenciamentoconsultas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author laral
 */
public class Gerenciamento implements CrudGerenciamento {
 // A anotação Override na IDE eclipse não é nescessario  colocar 
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
        System.out.println("Paciente Cadastrado");
    }

    public void cadastrarMedico(Medico m) {
        listMedicos.add(m);
        System.out.println("Medico Cadatrado");
    }

    public void cadastrarConsulta(Consulta c) {
        listConsultas.add(c);
        System.out.println("Consulta Cadastrada");
    }

    public Endereco setarEndereco() {
        Endereco endereco = new Endereco();
        System.out.print("Rua: ");
        endereco.setRua(s.nextLine());
        System.out.print("Bairro: ");
        endereco.setBairro(s.nextLine());
        System.out.print("Estado: ");
        endereco.setEstado(s.nextLine());
        System.out.print("Cidade: ");
        endereco.setCidade(s.nextLine());
        try {
            System.out.print("Cep: ");
            endereco.setCep(s.nextInt());
        } catch (NumberFormatException e) {
            System.out.println("Erro: A entrada informada não é um número");
        }
        try {
            System.out.print("Numero Residencia: ");
            endereco.setNumero(s.nextInt());
            s.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("Erro: A entrada informada não é um número");
        }
        return endereco;
    }

    public Pessoa setarPessoa() {
        Pessoa p = new Pessoa();
        System.out.print("Nome: ");
        p.setNome(s.nextLine());
        try {
            System.out.print("Telefone: ");
            p.setTelefone(s.nextLong());
        } catch (NumberFormatException e) {
            System.out.println("Erro: A entrada informada não é um número inteiro");
        }
        try {
            System.out.print("CPF: ");
            p.setCpf(s.nextLong());
            s.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("Erro: A entrada informada não é um número inteiro");
        }
        System.out.print("Data De nascimento XX/XX/XXXX: ");
        String dataNasc = s.nextLine();
        try {
            p.setDataNascimento(format.parse(dataNasc));
        } catch (ParseException e) {

            System.out.println("Data de nascimento errada");
        }
        p.setEndereco(setarEndereco());
        return p;
    }

    public Paciente setarPaciente() {
        Paciente paciente = new Paciente();
        Pessoa pessoa;
        pessoa = setarPessoa();
        paciente.setCpf(pessoa.getCpf());
        paciente.setDataNascimento(pessoa.getDataNascimento());
        paciente.setNome(pessoa.getNome());
        paciente.setTelefone(pessoa.getTelefone());
        paciente.setEndereco(pessoa.getEndereco());

        System.out.print("Convenio: ");
        paciente.setConvenio(s.nextLine());

        return paciente;
    }

    public Consulta setarConsulta() {
        s.nextLine();
        Consulta consulta = new Consulta();
        System.out.println("Data consulta XX/XX/XXXX HH:mm");
        try {
            LocalDateTime dateTime = LocalDateTime.parse(s.nextLine(), formatter);
            consulta.setHorarioEdata(dateTime);
            consulta.setConsultorio(setarConsultorio());
        } catch (DateTimeParseException e) {
            System.out.println("Erro: A data informada é invalida");
        }
        long cpf = 0;
        try {
            System.out.print("CPF do paciente: ");
            cpf = s.nextLong();
            s.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("Erro: A entrada informada não é um número válido");
        }
        if (listPacientes.isEmpty()) {
            System.out.println("Paciente não cadastrado");

            return null;
        }
        int i = 0;
        for (Paciente p : listPacientes) {
            if (p.getCpf() == cpf) {
                consulta.setPaciente(p);
                i++;
            }
        }
        if (i == 0) {
            System.out.println("Paciente não cadastrado");
            return null;
        }
        System.out.println("Informe a especialização: ");
        String especializacao = s.nextLine().toLowerCase();
        for (Medico medico : listMedicos) {
            if (medico.getEspecializacao().toLowerCase().equals(especializacao)) {
                System.out.println("Nome: " + medico.getNome() + ", CRM: " + medico.getCrm());
            }
        }
        int crm = 0;
        try {
            System.out.println("CRM do Médico: ");
            crm = s.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("Erro: A entrada informada não é um número");
        }

        if (listMedicos.isEmpty()) {
            System.out.println("Médico não cadastrado");
            return null;
        }
        int j = 0;
        for (Medico m : listMedicos) {
            if (m.getCrm() == crm) {
                consulta.setMedico(m);
                j++;
            }
        }
        if (j == 0) {
            System.out.println("médico não Cadastrado");
            return null;
        }
        return consulta;
    }

    public Medico setarMedico() {
        Medico medico = new Medico();
        Pessoa pessoa;
        pessoa = setarPessoa();
        medico.setCpf(pessoa.getCpf());
        medico.setDataNascimento(pessoa.getDataNascimento());
        medico.setNome(pessoa.getNome());
        medico.setTelefone(pessoa.getTelefone());
        medico.setEndereco(pessoa.getEndereco());
        s.nextLine();
        System.out.println("Especialização: ");
        medico.setEspecializacao(s.nextLine());
        System.out.println("Email: ");
        medico.setEmail(s.nextLine());
        try {
            System.out.println("CRM: ");
            medico.setCrm(s.nextInt());
        } catch (NumberFormatException e) {
            System.out.println("Erro: A entrada informada não é um número");
        }

        return medico;
    }

    public Consultorio setarConsultorio() {
        Consultorio consultorio = new Consultorio();
        System.out.println("Nome legal: ");
        consultorio.setNomeLegal(s.nextLine());
        try {
            System.out.println("CNPJ: ");
            consultorio.setCnpj(s.nextInt());
            s.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("Erro: A entrada informada não é um números");
        }

        consultorio.setEndereco(setarEndereco());

        return consultorio;
    }

    public boolean confirmarPresenca() {
        if (listPacientes.isEmpty() && listMedicos.isEmpty() && listConsultas.isEmpty()) {
            System.out.println("Não é possível cadastrar");
        }
        long cpf = 0;
        try {
            System.out.println("CPF:");
            cpf = s.nextLong();
        } catch (NumberFormatException e) {
            System.out.println("Erro: A entrada informada não é um número");
        }

        int i = 0;
        Paciente paciente = null;
        for (Paciente p : listPacientes) {
            if (p.getCpf() == cpf) {
                paciente = p;
            }
        }

        if (paciente == null) {
            System.out.println("Paciente não cadastrado");
            return false;
        }
        int index = 0;
        int validador = 0;
        for (Consulta consulta : listConsultas) {
            if (consulta.getPaciente().getCpf() == cpf && consulta.isSituacaoConsulta() == false) {
                index = listConsultas.indexOf(consulta);
                System.out.println("Número da Consulta: " + index + " Data: " + consulta.getHorarioEdata());
                validador = 1;
            }

        }
        if (validador == 0) {
            System.out.println("Não há consultas");
            return false;
        }
        Consulta consulta = listConsultas.get(index);
        consulta.setSituacaoConsulta(true);
        System.out.println("Informe qual consulta você quer registrar: ");
        int posicao = s.nextInt();
        listConsultas.set(posicao, consulta);
        return true;
    }

    public void setarDiagnostico() {
        long cpf = 0;
        try {
            System.out.println("CPF:");
            cpf = s.nextLong();
        } catch (NumberFormatException e) {
            System.out.println("Erro : A entrada informada não é um número");
        }

        for (int i = 0; i < listConsultas.size(); i++) {
            Consulta consulta = listConsultas.get(i);
            if (consulta.getPaciente().getCpf() == cpf) {
                System.out.println("Número da consulta: " + i + " | Data da consulta: " + consulta.getHorarioEdata());
            }
        }
        int opcao = 0;
        try {
            System.out.println("Informe qual consulta você quer alterar: ");
            opcao = s.nextInt();
            s.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("Erro: A entrada informada não é numero");
        }

        int i = 0;
        for (Consulta consulta : listConsultas) {
            if (opcao == i) {
                System.out.println("Diagnóstico: ");
                consulta.setDiagnostico(s.nextLine());
            }
            i++;
        }
    }

    public void listarConsultasPaciente() {
        long cpf = 0;
        try {
            System.out.println("CPF:");
            cpf = s.nextLong();
        } catch (NumberFormatException e) {
            System.out.println("Erro: A entrada informada é invalida");
        }
        s.nextLine();
        int i = 0;
        for (Consulta consulta : listConsultas) {
            if (consulta.getPaciente().getCpf() == cpf) {
                System.out.println(consulta);
                i++;
            }
        }
        if (i == 0) {
            System.out.println("Não há consultas");
        }
    }
    
    public void listarPacientes() {
        System.out.println("-------------- Pacientes --------------");
        for (Paciente p : listPacientes) {
            System.out.println("Nome: " + p.getNome() + ", CPF: " + p.getCpf());
        }
    }
    
    public void listarMedicos() {
        System.out.println("-------------- Médicos --------------");
        for (Medico m : listMedicos) {
            System.out.println("Nome: " + m.getNome() + ", CRM: " + m.getCrm() + ", Especialização: " + m.getEspecializacao());
        }
    }

    public void setarObjetoPaciente() {
        Endereco endereco = new Endereco("Rua Exemplo", "Bairro Exemplo", 123, 12345678, "Estado Exemplo",
                "Cidade Exemplo");

        Paciente paciente = new Paciente();
        paciente.setNome("Joao dos Santos");
        paciente.setCpf(123456789);
        String dataString = "15/12/1972";
        try {
            paciente.setDataNascimento(format.parse(dataString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        paciente.setConvenio("unimed");
        paciente.setEndereco(endereco);
        paciente.setTelefone(457545454);
        listPacientes.add(paciente);

        Endereco enderecoPaciente2 = new Endereco("Rua dos Pacientes", "Jardim das Flores", 789, 44556677, "SP", "Campinas");
        Paciente paciente2 = new Paciente();
        paciente2.setNome("Maria Oliveira");
        paciente2.setCpf(987654321);
        String dataStringPaciente2 = "05/03/1990";
        try {
            paciente2.setDataNascimento(format.parse(dataStringPaciente2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        paciente2.setConvenio("Amil");
        paciente2.setEndereco(enderecoPaciente2);
        paciente2.setTelefone(998877665);
        listPacientes.add(paciente2);
    }

    public void setarObjetoMedico() {
        Endereco enderecoMedico = new Endereco("Rua Exemplo", "Bairro Exemplo", 123, 12345678, "SP", "São Paulo");
        String dataString = "15/12/1972";
        Medico medico = null;
        try {
            medico = new Medico("Cardiologia", 12345, "medico.exemplo@email.com", "Dr. João Silva", 987654321,
                    123456789, format.parse(dataString), enderecoMedico);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        listMedicos.add(medico);
        Endereco enderecoMedico2 = new Endereco("Rua dos Médicos", "Centro", 456, 11223344, "RJ", "Rio de Janeiro");
        String dataStringMedico2 = "20/05/1980";
        Medico medico2 = null;
        try {
            medico2 = new Medico("Neurologia", 54321, "medica.exemplo@email.com", "Dra. Ana Beatriz", 999887766,
                    987654321, format.parse(dataStringMedico2), enderecoMedico2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        listMedicos.add(medico2);
    }

    public void setarObjetoConsulta() {
        Endereco enderecoMedico = new Endereco("Rua Exemplo", "Bairro Exemplo", 123, 12345678, "SP", "São Paulo");
        String dataString = "15/12/1972";
        Medico medico = null;
        try {
            medico = new Medico("Cardiologia", 12345, "medico.exemplo@email.com", "Dr. João Silva", 987654321,
                    123456789, format.parse(dataString), enderecoMedico);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Criando o paciente
        Endereco enderecoPaciente = new Endereco("Rua Exemplo", "Bairro Exemplo", 123, 12345678, "Estado Exemplo",
                "Cidade Exemplo");

        Paciente paciente = new Paciente();
        paciente.setNome("Joao dos Santos");
        paciente.setCpf(123456789);
        String dataString2 = "15/12/1972";
        try {
            paciente.setDataNascimento(format.parse(dataString2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        paciente.setConvenio("unimed");
        paciente.setEndereco(enderecoPaciente);
        paciente.setTelefone(457545454);

        Endereco enderecoConsultorio = new Endereco("Rua Exemplo", "Bairro Exemplo", 123, 12345678, "Estado Exemplo",
                "Cidade Exemplo");
        Consultorio consultorio = new Consultorio("Consultório 101", 454545, enderecoConsultorio);

        Consulta consulta = new Consulta(medico,
                paciente,
                LocalDateTime.of(2024, 12, 10, 14, 30),
                "Diagnóstico inicial: Hipertensão",
                consultorio
        );
        listConsultas.add(consulta);
        //Segundo
        Endereco enderecoMedico2 = new Endereco("Rua das Palmeiras", "Centro", 456, 11223344, "RJ", "Rio de Janeiro");
        String dataStringMedico2 = "20/05/1980";
        Medico medico2 = null;
        try {
            medico2 = new Medico("Neurologia", 54321, "medica.exemplo@email.com", "Dra. Ana Beatriz", 999887766,
                    987654321, format.parse(dataStringMedico2), enderecoMedico2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Endereco enderecoPaciente2 = new Endereco("Rua Coronel Antonio", "Jardim das Flores", 789, 44556677, "SP", "Campinas");
        Paciente paciente2 = new Paciente();
        paciente2.setNome("Maria Oliveira");
        paciente2.setCpf(987654321);
        String dataStringPaciente2 = "05/03/1990";
        try {
            paciente2.setDataNascimento(format.parse(dataStringPaciente2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        paciente2.setConvenio("Amil");
        paciente2.setEndereco(enderecoPaciente2);
        paciente2.setTelefone(998877665);

        Endereco enderecoConsultorio2 = new Endereco("Rua XX de novembro", "Centro Médico", 321, 55667788, "MG", "Belo Horizonte");
        Consultorio consultorio2 = new Consultorio("Consultório 202", 454546, enderecoConsultorio2);

        Consulta consulta2 = new Consulta(
                medico2,
                paciente2,
                LocalDateTime.of(2024, 11, 20, 10, 0),
                "Diagnóstico inicial: Enxaqueca Crônica",
                consultorio2
        );
        listConsultas.add(consulta2);
    }
}
