import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CadastrarCliente {

    // Lista que armazena todos os clientes cadastrados
    private static List<String[]> clientes = new ArrayList<>();

    // Menu de Cliente
    public static void menu() {
        int opcao = 0;

        do {
            Menu menuCliente = new Menu("Menu Cliente", Arrays.asList(
                "Cadastrar Cliente",
                "Listar Clientes",
                "Voltar"
            ));
            opcao = menuCliente.getSelection();

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    System.out.println("Voltando...");
                    break;
            }

        } while (opcao != 3);
    }

    // Cadastra um novo cliente
    static void cadastrar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Saldo inicial: R$ ");
        try {
            double saldo = Double.parseDouble(scanner.nextLine());
            clientes.add(new String[]{nome, cpf, String.format("%.2f", saldo)});
            System.out.println("\nCliente '" + nome + "' cadastrado com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("Saldo invalido! Digite um numero.");
        }
    }

    // Lista todos os clientes cadastrados
    static void listar() {
        if (clientes.isEmpty()) {
            System.out.println("\nNenhum cliente cadastrado.");
            return;
        }

        System.out.println("\n=== Lista de Clientes ===");
        for (int i = 0; i < clientes.size(); i++) {
            String[] c = clientes.get(i);
            System.out.println((i + 1) + ". Nome: " + c[0] +
                " | CPF: " + c[1] +
                " | Saldo: R$ " + c[2]);
        }
    }
}