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
        listaDeTarefas.getListaDeTarefas().add(tarefa);
        System.out.println();
        System.out.println("Tarefa #" + tarefa.getId() + " adicionada com sucesso!");
        System.out.println();
    }

    public void removerTarefaPorId(Scanner sc) {
        try {
            if (listaDeTarefas.getListaDeTarefas().isEmpty()) {
                throw new ListaVaziaExcpetion();
            } else {
                System.out.println();
                System.out.println("======================= REMOVER TAREFA =========================");

                System.out.print("Digite o ID da tarefa que deseja excluir: ");
                int idRemovido = sc.nextInt();

                sc.nextLine();

                Tarefa tarefaParaExcluir = null;

                for (Tarefa tarefa : listaDeTarefas.getListaDeTarefas()) {
                    if (tarefa.getId() == idRemovido) {
                        tarefaParaExcluir = tarefa;
                        break;
                    }
                }

                try {
                    if (tarefaParaExcluir == null) {
                        throw new TarefaNaoEncontradaExcpetion();
                    }
                } catch (TarefaNaoEncontradaExcpetion e) {
                    System.out.println(e.getMessage());
                }

                System.out.println();

                System.out.print("Tem certeza que deseja excluir essa tarefa? (S/N): ");
                String confirmacaoRemover = sc.nextLine();


                if (confirmacaoRemover.equalsIgnoreCase("S")) {
                    listaDeTarefas.getListaDeTarefas().remove(tarefaParaExcluir);
                    System.out.println();
                    System.out.println("Tarefa #" + idRemovido + " removida com sucesso!");
                    System.out.println();
                } else {
                    System.out.println();
                    System.out.println("Operação cancelada.");
                    System.out.println();
                    return;
                }
            }
        } catch (ListaVaziaExcpetion e) {
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
        }
    }
}
