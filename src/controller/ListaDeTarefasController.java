package controller;

import exceptions.ListaVaziaExcpetion;
import exceptions.OpcaoInvalidaExcpetion;
import exceptions.TarefaConcluidaException;
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

    public void concluirTarefa(Scanner sc) {
        try {
            if (listaDeTarefas.getListaDeTarefas().isEmpty()) {
                throw new ListaVaziaExcpetion();
            } else {
                System.out.println();
                System.out.println("======================= CONCLUIR TAREFA ========================");
                System.out.print("Digite o ID da tarefa que deseja concluir: ");
                int idConcluido = sc.nextInt();

                sc.nextLine();

                try {
                    for (Tarefa tarefa : listaDeTarefas.getListaDeTarefas()) {
                        try {
                            if (tarefa.getId() == idConcluido && tarefa.getConcluido()) {
                                throw new TarefaConcluidaException();
                            } else if (tarefa.getId() == idConcluido && !tarefa.getConcluido()) {
                                tarefa.setConcluido(true);
                                System.out.println();
                                System.out.println("Tarefa #" + tarefa.getId() + " concluida com sucesso!");
                                System.out.println();
                            } else {
                                throw new TarefaNaoEncontradaExcpetion();
                            }
                        } catch (TarefaNaoEncontradaExcpetion e) {
                            System.out.println(e.getMessage());
                        }
                    }
                } catch (TarefaConcluidaException e) {
                    System.out.println();
                    System.out.println(e.getMessage());
                    System.out.println();
                }

            }
        } catch (ListaVaziaExcpetion e) {
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
        }
    }


}
