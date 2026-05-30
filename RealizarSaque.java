import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RealizarSaque {

    // Saldo atual da conta
    private static double saldoAtual = 1000.0;

    // Lista de transacoes realizadas4
    private static List<String[]> transacoes = new ArrayList<>();

    // Menu de Saque
    public static void menu() {
        int opcao = 0;

        do {
            Menu menuSaque = new Menu("Menu Saque", Arrays.asList(
                "Realizar Saque",
                "Alterar Saldo",
                "Ver Historico",
                "Voltar"
            ));
            opcao = menuSaque.getSelection();

            switch (opcao) {
                case 1:
                    realizarSaque();
                    break;
                case 2:
                    alterarSaldo();
                    break;
                case 3:
                    verHistorico();
                    break;
                case 4:
                    System.out.println("Voltando...");
                    break;
            }

        } while (opcao != 4);
    }

    // Realiza um saque na conta
    static void realizarSaque() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSaldo atual: R$ " + String.format("%.2f", saldoAtual));
        System.out.print("Valor do saque: R$ ");

        try {
            double valor = Double.parseDouble(scanner.nextLine().replace(",", "."));

            if (valor <= 0) {
                System.out.println("Valor deve ser maior que zero!");
            } else if (valor > saldoAtual) {
                System.out.println("Saldo insuficiente!");
            } else {
                saldoAtual -= valor;
                transacoes.add(new String[]{"Saque", String.format("%.2f", valor)});
                System.out.println("Saque de R$ " + String.format("%.2f", valor) + " realizado!");
                System.out.println("Saldo atual: R$ " + String.format("%.2f", saldoAtual));
            }

        } catch (NumberFormatException e) {
            System.out.println("Valor invalido! Digite um numero.");
        }
    }

    // Altera o saldo da conta manualmente
    static void alterarSaldo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSaldo atual: R$ " + String.format("%.2f", saldoAtual));
        System.out.print("Novo saldo: R$ ");

        try {
            double novoSaldo = Double.parseDouble(scanner.nextLine().replace(",", "."));
            transacoes.add(new String[]{"Deposito", String.format("%.2f", novoSaldo)});
            saldoAtual = novoSaldo;
            System.out.println("Saldo atualizado para R$ " + String.format("%.2f", saldoAtual));
        } catch (NumberFormatException e) {
            System.out.println("Valor invalido! Digite um numero.");
        }
    }

    // Exibe historico de transacoes
    static void verHistorico() {
        if (transacoes.isEmpty()) {
            System.out.println("\nNenhuma transacao registrada.");
            return;
        }

        System.out.println("\n=== Historico de Transacoes ===");
        double total = 0;

        for (int i = 0; i < transacoes.size(); i++) {
            String[] t = transacoes.get(i);
            System.out.println((i + 1) + ". " + t[0] + " - R$ " + t[1]);
            total += Double.parseDouble(t[1].replace(",", "."));
        }

        System.out.println("\nTotal movimentado: R$ " + String.format("%.2f", total));
    }
}