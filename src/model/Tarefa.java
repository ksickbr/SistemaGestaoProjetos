package model;

public class Tarefa {

    private String titulo;
    private String status;

    public Tarefa(String titulo, String status) {
        this.titulo = titulo;
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getStatus() {
        return status;
    }
}