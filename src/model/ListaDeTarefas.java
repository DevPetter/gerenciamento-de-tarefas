package model;

import java.util.ArrayList;
import java.util.List;

public class ListaDeTarefas {
    private List<Tarefa> listaDeTarefas;

    public ListaDeTarefas() {
        this.listaDeTarefas = new ArrayList<>();
    }

    public List<Tarefa> getListaDeTarefas() {
        return listaDeTarefas;
    }
}
