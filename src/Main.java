import model.Usuario;
import model.Projeto;
import model.Equipe;
import model.Tarefa;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Projeto> projetos = new ArrayList<>();
        ArrayList<Equipe> equipes = new ArrayList<>();
        ArrayList<Tarefa> tarefas = new ArrayList<>();

        int opcao;

        do {

            System.out.println("\n=== SISTEMA DE GESTÃO DE PROJETOS ===");
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Listar Usuários");
            System.out.println("3 - Cadastrar Projeto");
            System.out.println("4 - Listar Projetos");
            System.out.println("5 - Cadastrar Equipe");
            System.out.println("6 - Listar Equipes");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");


            switch (opcao) {

                case 1:


                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    String email = scanner.nextLine();


                    usuarios.add(usuario);

                    System.out.println("Usuário cadastrado com sucesso!");

                    break;

                case 2:

                    System.out.println("\n=== USUÁRIOS CADASTRADOS ===");

                    if (usuarios.isEmpty()) {

                        System.out.println("Nenhum usuário cadastrado.");

                    } else {

                        for (Usuario u : usuarios) {

                            System.out.println(
                                            + " | CPF: " + u.getCpf()
                            );

                        }

                    }

                    break;

                case 3:

                    System.out.print("Nome do projeto: ");
                    String nomeProjeto = scanner.nextLine();

                    String descricaoProjeto = scanner.nextLine();

                    String statusProjeto = scanner.nextLine();

                    Projeto projeto = new Projeto(
                            nomeProjeto,
                            descricaoProjeto,
                    );

                    projetos.add(projeto);

                    System.out.println("Projeto cadastrado com sucesso!");

                    break;

                case 4:

                    System.out.println("\n=== PROJETOS CADASTRADOS ===");

                    if (projetos.isEmpty()) {

                        System.out.println("Nenhum projeto cadastrado.");

                    } else {

                        for (Projeto p : projetos) {

                            System.out.println(
                                    "Nome: " + p.getNome()
                                            + " | Descrição: " + p.getDescricao()
                                            + " | Status: " + p.getStatus()
                            );

                        }

                    }

                    break;

                case 5:

                    System.out.print("Nome da equipe: ");
                    String nomeEquipe = scanner.nextLine();

                    System.out.print("Descrição da equipe: ");
                    String descricaoEquipe = scanner.nextLine();

                    Equipe equipe = new Equipe(
                            nomeEquipe,
                            descricaoEquipe
                    );

                    equipes.add(equipe);

                    System.out.println("Equipe cadastrada com sucesso!");

                    break;

                case 6:

                    System.out.println("\n=== EQUIPES CADASTRADAS ===");

                    if (equipes.isEmpty()) {

                        System.out.println("Nenhuma equipe cadastrada.");

                    } else {

                        for (Equipe e : equipes) {

                            System.out.println(
                                    "Nome: " + e.getNome()
                                            + " | Descrição: " + e.getDescricao()
                            );

                        }

                    }

                    break;

                case 7:

                    System.out.print("Título da tarefa: ");
                    String titulo = scanner.nextLine();

                    String statusTarefa = scanner.nextLine();

                    Tarefa tarefa = new Tarefa(
                            titulo,
                    );

                    tarefas.add(tarefa);

                    System.out.println("Tarefa cadastrada com sucesso!");

                    break;


                    System.out.println("\n=== TAREFAS CADASTRADAS ===");

                    if (tarefas.isEmpty()) {

                        System.out.println("Nenhuma tarefa cadastrada.");

                    } else {

                        for (Tarefa t : tarefas) {

                            System.out.println(
                                    "Título: " + t.getTitulo()
                                            + " | Status: " + t.getStatus()
                            );

                        }

                    }

                    break;


                    System.out.println("\n=== RELATÓRIO GERAL ===");

                    System.out.println("Usuários cadastrados: " + usuarios.size());
                    System.out.println("Projetos cadastrados: " + projetos.size());
                    System.out.println("Equipes cadastradas: " + equipes.size());
                    System.out.println("Tarefas cadastradas: " + tarefas.size());

                    break;

                case 0:

                    System.out.println("Encerrando sistema...");
                    break;

                default:

                    System.out.println("Opção inválida.");

            }

        } while (opcao != 0);

        scanner.close();

    }
}