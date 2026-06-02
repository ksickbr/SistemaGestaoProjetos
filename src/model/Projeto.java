package model;

import java.util.ArrayList;
import java.util.List;

public class Projeto {

    private String nome;
    private String descricao;
    private String dataInicio;
    private String dataTerminoPrevista;
    private String status;
    private Usuario gerenteResponsavel;
    private List<Equipe> equipes;

    public Projeto(String nome, String descricao, String status) {
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.dataInicio = "";
        this.dataTerminoPrevista = "";
        this.gerenteResponsavel = null;
        this.equipes = new ArrayList<>();
    }

    public Projeto(String nome, String descricao, String dataInicio, String dataTerminoPrevista, String status, Usuario gerenteResponsavel) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTerminoPrevista = dataTerminoPrevista;
        this.status = status;
        this.gerenteResponsavel = gerenteResponsavel;
        this.equipes = new ArrayList<>();
    }

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