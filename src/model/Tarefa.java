package model;

public class Tarefa {
    private int proximoId = 1;
    private int id;
    private int nivelDePrioridade;
    private String titulo;
    private String descricao;
    private boolean concluido;

    public Tarefa(int nivelDePrioridade, String titulo, String descricao) {
        this.nivelDePrioridade = nivelDePrioridade;
        this.titulo = titulo;
        this.descricao = descricao;
        this.id = proximoId ++;
        this.concluido = false;
    }

    public int getId() {
        return id;
    }

    public int getNivelDePrioridade() {
        return nivelDePrioridade;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean getConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public void exibirTarefa(){
        System.out.println("==================== TAREFA #" + getId() + " ====================");
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Nível de prioridade: " + getNivelDePrioridade());
        if(getConcluido()){
            System.out.println("Concluido: Sim");
        }else{
            System.out.println("Concluido: Não");
        }
        System.out.println("=================================================================");
        System.out.println();
    }
}
