package com.maisprati.crud;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class CRUD {
    private static ArrayList<Pessoa> cadastros = new ArrayList<>();
    private static Scanner scanner;

    public CRUD() {
        System.out.println("Olá");
        scanner = new Scanner(System.in);
        menu();

    }

    private void menu(){
        while (true) {
            // System.out.print("\033[H\033[2J");
            // System.out.flush();
            System.out.println("1-Cadastrar 2-Listar 3-Editar 4-Deletar x-Fechar");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    cadastrar();
                    break;
                case "2":
                    listar();
                    break;
                case "3":
                    editar();
                    break;
                case "4":
                    deletar();
                    break;
                case "x":
                    return;

            }
        }
    }

    private void cadastrar(){
        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();

        System.out.println("Digite o telefone:");
        Integer telefone = Integer.parseInt(scanner.nextLine().replaceAll("[^\\d]", "") );

        System.out.println("Digite a data de nascimento ddMMyyyy:");
        LocalDate nasc = LocalDate.parse(scanner.nextLine().replaceAll("[^\\d]", ""), DateTimeFormatter.ofPattern("ddMMyyyy"));

        System.out.println("Digite a nota final para cadastrar como aluno ou deixe em branco");
        String nota = scanner.nextLine().replaceAll("[^\\d.]", "");
        if (nota.isEmpty()) {
            cadastros.add(new Pessoa(nome, telefone, nasc));
        }
        else {
            cadastros.add(new Aluno(nome, telefone, nasc, Float.parseFloat(nota) ));
        }
    }

    private void editar(){
        System.out.println("Digite o ID do cadastro a editar");
        int ID = Integer.parseInt(scanner.nextLine().replaceAll("[^\\d]", "") );
        if (ID > cadastros.size() - 1) {
            System.out.println("Usuário não cadastrado");
            return;
        }
        System.out.println("Editando o cadastro de " + cadastros.get(ID).getNome() + " | 1 - Nome 2 - telefone 3- Data de nascimento");
        int edit = Integer.parseInt(scanner.nextLine().replaceAll("[^\\d]", "") );
        
        switch (edit) {
            case 1:
                System.out.println("Digite o nome:");
                String nome = scanner.nextLine();
                cadastros.get(ID).setNome(nome);
                break;
            
            case 2:
                System.out.println("Digite o telefone:");
                Integer telefone = Integer.parseInt(scanner.nextLine().replaceAll("[^\\d]", "") );
                cadastros.get(ID).setTelefone(telefone);
                break;
            case 3:
                System.out.println("Digite a data de nascimento ddMMyyyy:");
                LocalDate nasc = LocalDate.parse(scanner.nextLine().replaceAll("[^\\d]", ""), DateTimeFormatter.ofPattern("ddMMyyyy"));
                cadastros.get(ID).setDataNascimento(nasc);
                break;
            default:
                break;
        }
        
    }

    private void listar(){
        if (cadastros.isEmpty()) {
            System.out.println("Nenhum cadastro encontrado");
            return;
        }
        System.out.println("ID   Nome     Classe");
        for (int i = 0; i < cadastros.size(); i++) {
            System.out.println(i + "   " + cadastros.get(i).getNome() + "   " + cadastros.get(i).getClass().getSimpleName());
        }
        System.out.println("Digite o ID para ver detalhes");
        String input = scanner.nextLine().replaceAll("[^\\d]", "");
        if (input.isBlank()) {
            return;            
        } else {
            int ID = Integer.parseInt(input );
            if (ID > cadastros.size() - 1) {
                System.out.println("Usuário não cadastrado");
                return;
            }
            System.out.println("Nome: " + cadastros.get(ID).getNome());
            System.out.println("Telefone: " + cadastros.get(ID).getTelefone());
            System.out.println("Data nascimento: " + cadastros.get(ID).getDataNascimento());
            System.out.println("Data cadastro: " + cadastros.get(ID).getDataCadastro());
            System.out.println("Ultima alteração: " + cadastros.get(ID).getUltimaAlteracao());
            if (cadastros.get(ID) instanceof Aluno) {
                System.out.println("Nota Final: " + ((Aluno) cadastros.get(ID)).getNotaFinal());
            }
        }
    }

    private void deletar(){
        System.out.println("Digite o ID do cadastro a excluir");
        int ID = Integer.parseInt(scanner.nextLine().replaceAll("[^\\d]", "") );
        if (ID > cadastros.size() - 1) {
            System.out.println("Usuário não cadastrado");
            return;
        }
        System.out.println("Deseja excluir o cadastro de " + cadastros.get(ID).getNome() + "?(Sim/Não");
        String confirmacao = scanner.nextLine().toUpperCase();
        if (confirmacao.contentEquals("SIM")) {
            cadastros.remove(ID);
            System.out.println("Registro removido");
        }
        else{
            System.out.println("Nenhuma alteração feita");
        }

    }

}
