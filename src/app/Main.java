package app;

import controller.ListaDeTarefasController;
import model.ListaDeTarefas;
import view.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaDeTarefas listaDeTarefas = new ListaDeTarefas();
        ListaDeTarefasController controller = new ListaDeTarefasController(listaDeTarefas, sc);
        Menu menu = new Menu(controller, sc);

        menu.exibirMenu();
    }
}
