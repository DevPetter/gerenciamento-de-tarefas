package exceptions;

public class TarefaConcluidaException extends Exception{
    public TarefaConcluidaException(){
        super("[ERRO] - Tarefa já concluida.");
    }
}
