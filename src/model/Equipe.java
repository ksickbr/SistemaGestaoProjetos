package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma equipe do sistema.
 * Cada equipe possui nome, descrição e uma lista de usuários vinculados como membros.
 */
public class Equipe {

    // Atributos principais da equipe
    private String nome;
    private String descricao;

    // Lista de usuários que fazem parte da equipe
    private List<Usuario> membros;

    /**
     * Construtor utilizado para criar uma equipe com nome e descrição.
     * A lista de membros inicia vazia.
     */
    public Equipe(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.membros = new ArrayList<>();
    }

    /**
     * Adiciona um usuário como membro da equipe.
     */
    public void adicionarMembro(Usuario usuario) {
        this.membros.add(usuario);
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Usuario> getMembros() {
        return membros;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}