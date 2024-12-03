/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.gerenciamentoconsultas;

import java.util.Scanner;

/**
 *
 * @author laral
 */
public class GerenciamentoConsultas {

    public static void main(String[] args) {
        Gerenciamento g = new Gerenciamento();
        
        Scanner s = new Scanner(System.in);
        int opcao = 1;
        
        while(opcao >= 1 && opcao <= 7){
            System.out.println("----------------------------------");
            System.out.println("1- Cadastrar paciente");
            System.out.println("2- Cadastrar médico");
            System.out.println("3- Cadastrar consulta");
            System.out.println("4- Alterar dados do paciente");
            System.out.println("5- Alterar dados do médico");
            System.out.println("6- Alterar dados da consulta");
            System.out.println("7- Listar consultas do paciente");
            System.out.println("8- Sair \n");
            opcao = s.nextInt();
            s.nextLine();
            
            switch(opcao){
                case 1:
                    System.out.print("Nome: ");
                    String nome = s.nextLine();
                    Paciente p = new Paciente();
                    p.setConvenio(nome);
                    g.cadastrarPaciente(p);
                    break;
            }
        }
    }
}
