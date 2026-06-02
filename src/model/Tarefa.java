package model;

/**
 * Classe que representa uma tarefa do projeto.
 * Cada tarefa pode estar vinculada a um projeto e a um usuário responsável.
 */
public class Tarefa {

    // Atributos principais da tarefa
    private String titulo;
    private String descricao;
    private String prazo;
    private String status;

    // Usuário responsável pela execução da tarefa
    private Usuario responsavel;

    // Projeto ao qual a tarefa pertence
    private Projeto projeto;

    /**
     * Construtor simplificado, mantido para compatibilidade com versões anteriores.
     */
    public Tarefa(String titulo, String status) {
        this.titulo = titulo;
        this.descricao = "";
        this.prazo = "";
        this.status = status;
        this.responsavel = null;
        this.projeto = null;
    }

    /**
     * Construtor completo utilizado no cadastro de tarefas.
     */
    public Tarefa(String titulo, String descricao, String prazo, String status, Usuario responsavel, Projeto projeto) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
        this.status = status;
        this.responsavel = responsavel;
        this.projeto = projeto;
    }

    /**
     * Atualiza o status da tarefa.
     */
    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPrazo() {
        return prazo;
    }

    public String getStatus() {
        return status;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
}