import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AbrirConta {

    private static List<String[]> contas = new ArrayList<>();
    private static int proximoNumero = 1;

    public static void menu() {

        int opcao = 0;

        do {

            Menu menuConta = new Menu("Menu Conta", Arrays.asList(
                "Abrir Conta",
                "Listar Contas",
                "Consultar Conta",
                "Voltar"
            ));

            opcao = menuConta.getSelection();

            switch (opcao) {

                case 1:
                    abrirConta();
                    break;

                case 2:
                    listarContas();
                    break;

                case 3:
                    consultarConta();
                    break;

                case 4:
                    System.out.println("Voltando...");
                    break;
            }

        } while (opcao != 4);
    }

    public static void abrirConta() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do titular: ");
        String titular = scanner.nextLine();

        System.out.print("CPF do titular: ");
        String cpf = scanner.nextLine();

        String numeroConta = String.valueOf(proximoNumero++);

        contas.add(new String[]{
            numeroConta,
            titular,
            cpf
        });

        System.out.println("\nConta criada com sucesso!");
        System.out.println("Numero da conta: " + numeroConta);
        
        scanner.close();
    }

    public static void listarContas() {

        if (contas.isEmpty()) {
            System.out.println("\nNenhuma conta cadastrada.");
            return;
        }

        System.out.println("\n=== CONTAS CADASTRADAS ===");

        for (String[] conta : contas) {

            System.out.println(
                "Conta: " + conta[0] +
                " | Titular: " + conta[1] +
                " | CPF: " + conta[2]
            );
        }
    }

    public static void consultarConta() {

        if (contas.isEmpty()) {
            System.out.println("\nNenhuma conta cadastrada.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o numero da conta: ");
        String numeroConta = scanner.nextLine();

        boolean encontrada = false;

        for (String[] conta : contas) {

            if (conta[0].equals(numeroConta)) {

                System.out.println("\n=== DADOS DA CONTA ===");
                System.out.println("Numero: " + conta[0]);
                System.out.println("Titular: " + conta[1]);
                System.out.println("CPF: " + conta[2]);

                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            System.out.println("\nConta nao encontrada.");
        }
    }
}