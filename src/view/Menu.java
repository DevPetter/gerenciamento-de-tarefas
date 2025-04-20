package view;

import controller.ListaDeTarefasController;
import exceptions.ListaVaziaExcpetion;
import exceptions.OpcaoInvalidaExcpetion;
import model.Tarefa;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private ListaDeTarefasController controller;
    private Scanner sc;

    public Menu(ListaDeTarefasController controller, Scanner sc) {
        this.controller = controller;
        this.sc = sc;
    }

    public void exibirMenu() {
        while (true) {
            menuOpcoes();
            try {
                int opcao = sc.nextInt();
                System.out.println("================================================================");
                sc.nextLine();

                switch (opcao) {
                    case 0:
                        System.out.println();
                        System.out.println("Saindo...");
                        System.exit(0);
                    case 1:
                        criarTarefa();
                        break;
                    case 2:
                        controller.removerTarefaPorId(sc);
                        break;
                    case 3:
                        controller.concluirTarefa(sc);
                        break;
                    default:
                        throw new OpcaoInvalidaExcpetion();
                }
            } catch (OpcaoInvalidaExcpetion e) {
                System.out.println();
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    private void menuOpcoes() {
        System.out.println("==================== GERENCIADOR DE TAREFAS ====================");
        System.out.println("[1] - Criar nova tarefa");
        System.out.println("[2] - Excluir uma tarefa por ID");
        System.out.println("[3] - Concluir uma tarefa");
        System.out.println("[4] - Listar todas as tarefas CONCLUIDAS");
        System.out.println("[5] - Listar todas as tarefas NÃO CONCLUIDAS");
        System.out.println("[0] - Sair");
        System.out.println();
        System.out.print("Opção: ");
    }

    private void criarTarefa() {
        System.out.println();
        System.out.println("====================== CRIAR NOVA TAREFA =======================");
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Descrição: ");
        String descricao = sc.nextLine();
        System.out.print("Nível de prioridade (1 a 3): ");

        try {
            int nivelDePrioridade = sc.nextInt();

            if (nivelDePrioridade < 1 || nivelDePrioridade > 3) {
                throw new OpcaoInvalidaExcpetion();
            } else {
                controller.adicionarTarefa(new Tarefa(nivelDePrioridade, titulo, descricao));
            }
        } catch (OpcaoInvalidaExcpetion e) {
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
        }
    }


}
