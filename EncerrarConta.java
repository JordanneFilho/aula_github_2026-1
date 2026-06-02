import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EncerrarConta {

    // Registra contas encerradas: [numeroConta, titular, dataHoraEncerramento]
    private static List<String[]> contasEncerradas = new ArrayList<>();
    private static final DateTimeFormatter FORMATTER =
        DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    // Menu de Encerramento de Conta
    public static void menu() {
        int opcao = 0;

        do {
            Menu menuEncerrar = new Menu("Menu Encerrar Conta", Arrays.asList(
                "Encerrar Conta",
                "Ver Contas Encerradas",
                "Voltar"
            ));
            opcao = menuEncerrar.getSelection();

            switch (opcao) {
                case 1:
                    encerrarConta();
                    break;
                case 2:
                    verContasEncerradas();
                    break;
                case 3:
                    System.out.println("Voltando...");
                    break;
            }

        } while (opcao != 3);
    }

    // Encerra uma conta a partir do numero informado
    static void encerrarConta() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nInforme o numero da conta a encerrar: ");
        String numeroConta = scanner.nextLine().trim();

        if (numeroConta.isEmpty()) {
            System.out.println("Numero de conta invalido!");
            return;
        }

        // Verifica se a conta ja foi encerrada anteriormente
        for (String[] encerrada : contasEncerradas) {
            if (encerrada[0].equals(numeroConta)) {
                System.out.println("\nEsta conta ja foi encerrada em " + encerrada[2] + ".");
                return;
            }
        }

        System.out.print("Informe o nome do titular: ");
        String titular = scanner.nextLine().trim();

        if (titular.isEmpty()) {
            System.out.println("Nome do titular invalido!");
            return;
        }

        System.out.println("\n=== ATENCAO ===");
        System.out.println("Voce esta prestes a encerrar a conta: " + numeroConta);
        System.out.println("Titular: " + titular);
        System.out.println("Esta acao nao pode ser desfeita.");
        System.out.print("Confirma o encerramento? (S/N): ");
        String confirmacao = scanner.nextLine().trim();

        if (!confirmacao.equalsIgnoreCase("S")) {
            System.out.println("\nEncerramento cancelado.");
            return;
        }

        String dataHora = LocalDateTime.now().format(FORMATTER);
        contasEncerradas.add(new String[]{numeroConta, titular, dataHora});

        System.out.println("\n========================================");
        System.out.println("  Conta encerrada com sucesso!");
        System.out.println("  Numero : " + numeroConta);
        System.out.println("  Titular: " + titular);
        System.out.println("  Data   : " + dataHora);
        System.out.println("========================================");
    }

    // Lista todas as contas encerradas
    static void verContasEncerradas() {
        System.out.println("\n========================================");
        System.out.println("       CONTAS ENCERRADAS                ");
        System.out.println("========================================");

        if (contasEncerradas.isEmpty()) {
            System.out.println("Nenhuma conta encerrada ate o momento.");
            System.out.println("========================================");
            return;
        }

        for (int i = 0; i < contasEncerradas.size(); i++) {
            String[] c = contasEncerradas.get(i);
            System.out.printf(
                "%2d. Conta: %-6s | Titular: %-20s | Encerrada em: %s%n",
                (i + 1), c[0], c[1], c[2]
            );
        }

        System.out.println("========================================");
        System.out.println("Total de contas encerradas: " + contasEncerradas.size());
        System.out.println("========================================");
    }
}
