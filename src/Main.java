import model.Usuario;
import model.Projeto;
import model.Equipe;
import model.Tarefa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe principal do sistema.
 * Responsável por exibir o menu, receber os dados digitados pelo usuário
 * e executar as principais funcionalidades do Sistema de Gestão de Projetos.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Listas utilizadas para armazenar os dados cadastrados durante a execução do programa
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Projeto> projetos = new ArrayList<>();
        ArrayList<Equipe> equipes = new ArrayList<>();
        ArrayList<Tarefa> tarefas = new ArrayList<>();

        int opcao;

        // Estrutura de repetição responsável por manter o menu ativo até o usuário escolher sair
        do {

            System.out.println("\n=== SISTEMA DE GESTÃO DE PROJETOS ===");
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Listar Usuários");
            System.out.println("3 - Cadastrar Projeto");
            System.out.println("4 - Listar Projetos");
            System.out.println("5 - Cadastrar Equipe");
            System.out.println("6 - Listar Equipes");
            System.out.println("7 - Adicionar Usuário a uma Equipe");
            System.out.println("8 - Alocar Equipe em um Projeto");
            System.out.println("9 - Cadastrar Tarefa");
            System.out.println("10 - Listar Tarefas");
            System.out.println("11 - Relatório Geral");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = lerInteiro(scanner);

            switch (opcao) {

                case 1:

                    // Cadastro completo de usuário conforme os requisitos do projeto
                    System.out.print("Nome completo: ");
                    String nomeCompleto = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.print("E-mail: ");
                    String email = scanner.nextLine();

                    System.out.print("Cargo: ");
                    String cargo = scanner.nextLine();

                    System.out.print("Login: ");
                    String login = scanner.nextLine();

                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();

                    System.out.print("Perfil (administrador, gerente ou colaborador): ");
                    String perfil = scanner.nextLine();

                    Usuario usuario = new Usuario(
                            nomeCompleto,
                            cpf,
                            email,
                            cargo,
                            login,
                            senha,
                            perfil
                    );

                    usuarios.add(usuario);

                    System.out.println("Usuário cadastrado com sucesso!");

                    break;

                case 2:

                    // Listagem dos usuários cadastrados
                    System.out.println("\n=== USUÁRIOS CADASTRADOS ===");

                    if (usuarios.isEmpty()) {

                        System.out.println("Nenhum usuário cadastrado.");

                    } else {

                        for (Usuario u : usuarios) {

                            System.out.println(
                                    "Nome: " + u.getNomeCompleto()
                                            + " | CPF: " + u.getCpf()
                                            + " | E-mail: " + u.getEmail()
                                            + " | Cargo: " + u.getCargo()
                                            + " | Login: " + u.getLogin()
                                            + " | Perfil: " + u.getPerfil()
                            );

                        }

                    }

                    break;

                case 3:

                    // Para cadastrar um projeto, é necessário existir pelo menos um usuário para ser gerente
                    if (usuarios.isEmpty()) {
                        System.out.println("Cadastre pelo menos um usuário antes de cadastrar um projeto.");
                        break;
                    }

                    System.out.print("Nome do projeto: ");
                    String nomeProjeto = scanner.nextLine();

                    System.out.print("Descrição do projeto: ");
                    String descricaoProjeto = scanner.nextLine();

                    System.out.print("Data de início: ");
                    String dataInicio = scanner.nextLine();

                    System.out.print("Data de término prevista: ");
                    String dataTerminoPrevista = scanner.nextLine();

                    System.out.print("Status (planejado, em andamento, concluído ou cancelado): ");
                    String statusProjeto = scanner.nextLine();

                    System.out.println("\nSelecione o gerente responsável:");
                    listarUsuariosComIndice(usuarios);

                    System.out.print("Número do gerente: ");
                    int indiceGerente = lerInteiro(scanner) - 1;

                    if (!indiceValido(indiceGerente, usuarios.size())) {
                        System.out.println("Gerente inválido. Projeto não cadastrado.");
                        break;
                    }

                    Usuario gerente = usuarios.get(indiceGerente);

                    Projeto projeto = new Projeto(
                            nomeProjeto,
                            descricaoProjeto,
                            dataInicio,
                            dataTerminoPrevista,
                            statusProjeto,
                            gerente
                    );

                    projetos.add(projeto);

                    System.out.println("Projeto cadastrado com sucesso!");

                    break;

                case 4:

                    // Listagem dos projetos cadastrados, incluindo gerente e equipes alocadas
                    System.out.println("\n=== PROJETOS CADASTRADOS ===");

                    if (projetos.isEmpty()) {

                        System.out.println("Nenhum projeto cadastrado.");

                    } else {

                        for (Projeto p : projetos) {

                            String gerenteProjeto = "Não informado";

                            if (p.getGerenteResponsavel() != null) {
                                gerenteProjeto = p.getGerenteResponsavel().getNomeCompleto();
                            }

                            String equipesAlocadas = "Nenhuma equipe alocada";

                            if (!p.getEquipes().isEmpty()) {
                                equipesAlocadas = nomesEquipes(p.getEquipes());
                            }

                            System.out.println(
                                    "Nome: " + p.getNome()
                                            + " | Descrição: " + p.getDescricao()
                                            + " | Início: " + p.getDataInicio()
                                            + " | Término previsto: " + p.getDataTerminoPrevista()
                                            + " | Status: " + p.getStatus()
                                            + " | Gerente: " + gerenteProjeto
                                            + " | Equipes: " + equipesAlocadas
                            );

                        }

                    }

                    break;

                case 5:

                    // Cadastro de equipe
                    System.out.print("Nome da equipe: ");
                    String nomeEquipe = scanner.nextLine();

                    System.out.print("Descrição da equipe: ");
                    String descricaoEquipe = scanner.nextLine();

                    Equipe equipe = new Equipe(nomeEquipe, descricaoEquipe);

                    equipes.add(equipe);

                    System.out.println("Equipe cadastrada com sucesso!");

                    break;

                case 6:

                    // Listagem das equipes cadastradas e seus membros
                    System.out.println("\n=== EQUIPES CADASTRADAS ===");

                    if (equipes.isEmpty()) {

                        System.out.println("Nenhuma equipe cadastrada.");

                    } else {

                        for (Equipe e : equipes) {

                            String membros = "Nenhum membro vinculado";

                            if (!e.getMembros().isEmpty()) {
                                membros = nomesMembros(e.getMembros());
                            }

                            System.out.println(
                                    "Nome: " + e.getNome()
                                            + " | Descrição: " + e.getDescricao()
                                            + " | Membros: " + membros
                            );

                        }

                    }

                    break;

                case 7:

                    // Vincula um usuário cadastrado a uma equipe cadastrada
                    if (equipes.isEmpty() || usuarios.isEmpty()) {
                        System.out.println("É necessário ter pelo menos uma equipe e um usuário cadastrados.");
                        break;
                    }

                    System.out.println("\nSelecione a equipe:");
                    listarEquipesComIndice(equipes);

                    System.out.print("Número da equipe: ");
                    int indiceEquipe = lerInteiro(scanner) - 1;

                    if (!indiceValido(indiceEquipe, equipes.size())) {
                        System.out.println("Equipe inválida.");
                        break;
                    }

                    System.out.println("\nSelecione o usuário:");
                    listarUsuariosComIndice(usuarios);

                    System.out.print("Número do usuário: ");
                    int indiceUsuario = lerInteiro(scanner) - 1;

                    if (!indiceValido(indiceUsuario, usuarios.size())) {
                        System.out.println("Usuário inválido.");
                        break;
                    }

                    Equipe equipeSelecionada = equipes.get(indiceEquipe);
                    Usuario usuarioSelecionado = usuarios.get(indiceUsuario);

                    equipeSelecionada.adicionarMembro(usuarioSelecionado);

                    System.out.println("Usuário adicionado à equipe com sucesso!");

                    break;

                case 8:

                    // Aloca uma equipe cadastrada a um projeto cadastrado
                    if (projetos.isEmpty() || equipes.isEmpty()) {
                        System.out.println("É necessário ter pelo menos um projeto e uma equipe cadastrados.");
                        break;
                    }

                    System.out.println("\nSelecione o projeto:");
                    listarProjetosComIndice(projetos);

                    System.out.print("Número do projeto: ");
                    int indiceProjeto = lerInteiro(scanner) - 1;

                    if (!indiceValido(indiceProjeto, projetos.size())) {
                        System.out.println("Projeto inválido.");
                        break;
                    }

                    System.out.println("\nSelecione a equipe:");
                    listarEquipesComIndice(equipes);

                    System.out.print("Número da equipe: ");
                    int indiceEquipeProjeto = lerInteiro(scanner) - 1;

                    if (!indiceValido(indiceEquipeProjeto, equipes.size())) {
                        System.out.println("Equipe inválida.");
                        break;
                    }

                    Projeto projetoSelecionado = projetos.get(indiceProjeto);
                    Equipe equipeProjeto = equipes.get(indiceEquipeProjeto);

                    projetoSelecionado.adicionarEquipe(equipeProjeto);

                    System.out.println("Equipe alocada ao projeto com sucesso!");

                    break;

                case 9:

                    // Cadastro de tarefa vinculada a um responsável e a um projeto
                    if (usuarios.isEmpty() || projetos.isEmpty()) {
                        System.out.println("É necessário ter pelo menos um usuário e um projeto cadastrados.");
                        break;
                    }

                    System.out.print("Título da tarefa: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Descrição da tarefa: ");
                    String descricaoTarefa = scanner.nextLine();

                    System.out.print("Prazo da tarefa: ");
                    String prazo = scanner.nextLine();

                    System.out.print("Status da tarefa (pendente, em andamento ou concluída): ");
                    String statusTarefa = scanner.nextLine();

                    System.out.println("\nSelecione o responsável pela tarefa:");
                    listarUsuariosComIndice(usuarios);

                    System.out.print("Número do responsável: ");
                    int indiceResponsavel = lerInteiro(scanner) - 1;

                    if (!indiceValido(indiceResponsavel, usuarios.size())) {
                        System.out.println("Responsável inválido. Tarefa não cadastrada.");
                        break;
                    }

                    System.out.println("\nSelecione o projeto da tarefa:");
                    listarProjetosComIndice(projetos);

                    System.out.print("Número do projeto: ");
                    int indiceProjetoTarefa = lerInteiro(scanner) - 1;

                    if (!indiceValido(indiceProjetoTarefa, projetos.size())) {
                        System.out.println("Projeto inválido. Tarefa não cadastrada.");
                        break;
                    }

                    Usuario responsavel = usuarios.get(indiceResponsavel);
                    Projeto projetoTarefa = projetos.get(indiceProjetoTarefa);

                    Tarefa tarefa = new Tarefa(
                            titulo,
                            descricaoTarefa,
                            prazo,
                            statusTarefa,
                            responsavel,
                            projetoTarefa
                    );

                    tarefas.add(tarefa);

                    System.out.println("Tarefa cadastrada com sucesso!");

                    break;

                case 10:

                    // Listagem das tarefas cadastradas
                    System.out.println("\n=== TAREFAS CADASTRADAS ===");

                    if (tarefas.isEmpty()) {

                        System.out.println("Nenhuma tarefa cadastrada.");

                    } else {

                        for (Tarefa t : tarefas) {

                            String nomeResponsavel = "Não informado";
                            String nomeProjetoTarefa = "Não informado";

                            if (t.getResponsavel() != null) {
                                nomeResponsavel = t.getResponsavel().getNomeCompleto();
                            }

                            if (t.getProjeto() != null) {
                                nomeProjetoTarefa = t.getProjeto().getNome();
                            }

                            System.out.println(
                                    "Título: " + t.getTitulo()
                                            + " | Descrição: " + t.getDescricao()
                                            + " | Prazo: " + t.getPrazo()
                                            + " | Status: " + t.getStatus()
                                            + " | Responsável: " + nomeResponsavel
                                            + " | Projeto: " + nomeProjetoTarefa
                            );

                        }

                    }

                    break;

                case 11:

                    // Relatório geral de acompanhamento do sistema
                    System.out.println("\n=== RELATÓRIO GERAL ===");

                    System.out.println("Usuários cadastrados: " + usuarios.size());
                    System.out.println("Projetos cadastrados: " + projetos.size());
                    System.out.println("Equipes cadastradas: " + equipes.size());
                    System.out.println("Tarefas cadastradas: " + tarefas.size());

                    System.out.println("Tarefas pendentes: " + contarTarefasPorStatus(tarefas, "pendente"));
                    System.out.println("Tarefas em andamento: " + contarTarefasPorStatus(tarefas, "em andamento"));
                    System.out.println("Tarefas concluídas: " + contarTarefasPorStatus(tarefas, "concluída", "concluida"));

                    if (!projetos.isEmpty()) {

                        System.out.println("\nProjetos acompanhados:");

                        for (Projeto p : projetos) {

                            System.out.println(
                                    "- " + p.getNome()
                                            + " | Status: " + p.getStatus()
                                            + " | Equipes alocadas: " + p.getEquipes().size()
                            );

                        }

                    }

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

    /**
     * Lê um número inteiro digitado pelo usuário.
     * Caso o usuário digite um valor inválido, solicita nova entrada.
     */
    private static int lerInteiro(Scanner scanner) {

        while (true) {

            try {

                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.print("Digite um número válido: ");

            }

        }

    }

    /**
     * Verifica se o índice informado pelo usuário existe dentro de uma lista.
     */
    private static boolean indiceValido(int indice, int tamanhoLista) {
        return indice >= 0 && indice < tamanhoLista;
    }

    /**
     * Exibe os usuários cadastrados com numeração para seleção no menu.
     */
    private static void listarUsuariosComIndice(ArrayList<Usuario> usuarios) {

        for (int i = 0; i < usuarios.size(); i++) {

            Usuario usuario = usuarios.get(i);

            System.out.println(
                    (i + 1) + " - " + usuario.getNomeCompleto()
                            + " | Perfil: " + usuario.getPerfil()
            );

        }

    }

    /**
     * Exibe os projetos cadastrados com numeração para seleção no menu.
     */
    private static void listarProjetosComIndice(ArrayList<Projeto> projetos) {

        for (int i = 0; i < projetos.size(); i++) {

            Projeto projeto = projetos.get(i);

            System.out.println(
                    (i + 1) + " - " + projeto.getNome()
                            + " | Status: " + projeto.getStatus()
            );

        }

    }

    /**
     * Exibe as equipes cadastradas com numeração para seleção no menu.
     */
    private static void listarEquipesComIndice(ArrayList<Equipe> equipes) {

        for (int i = 0; i < equipes.size(); i++) {

            Equipe equipe = equipes.get(i);

            System.out.println(
                    (i + 1) + " - " + equipe.getNome()
            );

        }

    }

    /**
     * Retorna os nomes dos membros de uma equipe em formato de texto.
     */
    private static String nomesMembros(List<Usuario> membros) {

        StringBuilder nomes = new StringBuilder();

        for (int i = 0; i < membros.size(); i++) {

            nomes.append(membros.get(i).getNomeCompleto());

            if (i < membros.size() - 1) {
                nomes.append(", ");
            }

        }

        return nomes.toString();

    }

    /**
     * Retorna os nomes das equipes alocadas a um projeto em formato de texto.
     */
    private static String nomesEquipes(List<Equipe> equipes) {

        StringBuilder nomes = new StringBuilder();

        for (int i = 0; i < equipes.size(); i++) {

            nomes.append(equipes.get(i).getNome());

            if (i < equipes.size() - 1) {
                nomes.append(", ");
            }

        }

        return nomes.toString();

    }

    /**
     * Conta quantas tarefas existem para determinado status.
     */
    private static int contarTarefasPorStatus(ArrayList<Tarefa> tarefas, String... statusBuscados) {

        int total = 0;

        for (Tarefa tarefa : tarefas) {

            for (String status : statusBuscados) {

                if (tarefa.getStatus().equalsIgnoreCase(status)) {
                    total++;
                }

            }

        }

        return total;

    }
}