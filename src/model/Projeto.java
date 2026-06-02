package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um projeto no sistema.
 * Um projeto possui dados básicos, gerente responsável e equipes alocadas.
 */
public class Projeto {

    // Atributos principais do projeto
    private String nome;
    private String descricao;
    private String dataInicio;
    private String dataTerminoPrevista;
    private String status;

    // Usuário responsável pela gerência do projeto
    private Usuario gerenteResponsavel;

    // Lista de equipes vinculadas ao projeto
    private List<Equipe> equipes;

    /**
     * Construtor simplificado, mantido para compatibilidade com versões anteriores.
     */
    public Projeto(String nome, String descricao, String status) {
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.dataInicio = "";
        this.dataTerminoPrevista = "";
        this.gerenteResponsavel = null;
        this.equipes = new ArrayList<>();
    }

    /**
     * Construtor completo utilizado no cadastro de projetos.
     */
    public Projeto(String nome, String descricao, String dataInicio, String dataTerminoPrevista, String status, Usuario gerenteResponsavel) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTerminoPrevista = dataTerminoPrevista;
        this.status = status;
        this.gerenteResponsavel = gerenteResponsavel;
        this.equipes = new ArrayList<>();
    }

    /**
     * Adiciona uma equipe ao projeto.
     */
    public void adicionarEquipe(Equipe equipe) {
        this.equipes.add(equipe);
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataTerminoPrevista() {
        return dataTerminoPrevista;
    }

    public String getStatus() {
        return status;
    }

    public Usuario getGerenteResponsavel() {
        return gerenteResponsavel;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataTerminoPrevista(String dataTerminoPrevista) {
        this.dataTerminoPrevista = dataTerminoPrevista;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setGerenteResponsavel(Usuario gerenteResponsavel) {
        this.gerenteResponsavel = gerenteResponsavel;
    }
}