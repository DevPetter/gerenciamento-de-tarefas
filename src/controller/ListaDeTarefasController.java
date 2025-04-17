package controller;

import exceptions.ListaVaziaExcpetion;
import exceptions.OpcaoInvalidaExcpetion;
import exceptions.TarefaNaoEncontradaExcpetion;
import model.ListaDeTarefas;
import model.Tarefa;

import java.util.Scanner;

public class ListaDeTarefasController {
    private ListaDeTarefas listaDeTarefas;
    private Scanner sc;

    public ListaDeTarefasController(ListaDeTarefas listaDeTarefas, Scanner sc) {
        this.sc = sc;
        this.listaDeTarefas = listaDeTarefas;
    }

    public void adicionarTarefa(Tarefa tarefa) {
        try {
            if (listaDeTarefas.getListaDeTarefas().isEmpty()) {
                throw new ListaVaziaExcpetion();
            } else {
                listaDeTarefas.getListaDeTarefas().add(tarefa);
                System.out.println("Tarefa #" + tarefa.getId() + " adicionada com sucesso!");
                System.out.println();
            }
        } catch (ListaVaziaExcpetion e) {
            System.out.println(e.getMessage());
        }
    }

    public void removerTarefaPorId(int id, Scanner sc, ListaDeTarefasController controller) {
        try {
            if (listaDeTarefas.getListaDeTarefas().isEmpty()) {
                throw new ListaVaziaExcpetion();
            } else {
                System.out.print("Tem certeza que deseja excluir essa tarefa?: ");
                String confirmacaoRemover = sc.nextLine();

                try {
                    if (confirmacaoRemover.equalsIgnoreCase("n")) {
                        boolean removida = listaDeTarefas.getListaDeTarefas().removeIf(tarefa -> id == tarefa.getId());

                        try {
                            if (removida) {
                                System.out.println("Tarefa #" + id + " removida com sucesso!");
                            } else {
                                throw new TarefaNaoEncontradaExcpetion();
                            }
                        } catch (TarefaNaoEncontradaExcpetion e) {
                            System.out.println(e.getMessage());
                        }

                    } else if (confirmacaoRemover.equalsIgnoreCase("n")) {
                        return;
                    } else {
                        throw new OpcaoInvalidaExcpetion();
                    }
                } catch (OpcaoInvalidaExcpetion e) {
                    System.out.println(e.getMessage());
                }

            }
        } catch (ListaVaziaExcpetion e) {
            System.out.println(e.getMessage());
        }
    }
}
