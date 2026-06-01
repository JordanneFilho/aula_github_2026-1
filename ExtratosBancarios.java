import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExtratosBancarios {

    // Registra todas as movimentacoes: [tipo, valor, data/hora, saldo_apos]
    private static List<String[]> movimentacoes = new ArrayList<>();
    private static double saldoAtual = 0.0;
    private static final DateTimeFormatter FORMATTER =
        DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    // Menu de Extrato
    public static void menu() {
        int opcao = 0;

        do {
            Menu menuExtrato = new Menu("Menu Extrato Bancario", Arrays.asList(
                "Registrar Deposito",
                "Registrar Saque",
                "Ver Extrato Completo",
                "Ver Saldo Atual",
                "Voltar"
            ));
            opcao = menuExtrato.getSelection();

            switch (opcao) {
                case 1:
                    registrarDeposito();
                    break;
                case 2:
                    registrarSaque();
                    break;
                case 3:
                    verExtrato();
                    break;
                case 4:
                    verSaldo();
                    break;
                case 5:
                    System.out.println("Voltando...");
                    break;
            }

        } while (opcao != 5);
    }

    // Registra um deposito e salva no historico
    static void registrarDeposito() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nSaldo atual: R$ " + String.format("%.2f", saldoAtual));
        System.out.print("Valor do deposito: R$ ");

        try {
            double valor = Double.parseDouble(scanner.nextLine().replace(",", "."));

            if (valor <= 0) {
                System.out.println("Valor deve ser maior que zero!");
                return;
            }

            saldoAtual += valor;
            String dataHora = LocalDateTime.now().format(FORMATTER);
            movimentacoes.add(new String[]{
                "Deposito",
                String.format("%.2f", valor),
                dataHora,
                String.format("%.2f", saldoAtual)
            });

            System.out.println("\nDeposito de R$ " + String.format("%.2f", valor) + " realizado com sucesso!");
            System.out.println("Saldo atual: R$ " + String.format("%.2f", saldoAtual));

        } catch (NumberFormatException e) {
            System.out.println("Valor invalido! Digite um numero valido.");
        }
    }

    // Registra um saque e salva no historico
    static void registrarSaque() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nSaldo atual: R$ " + String.format("%.2f", saldoAtual));
        System.out.print("Valor do saque: R$ ");

        try {
            double valor = Double.parseDouble(scanner.nextLine().replace(",", "."));

            if (valor <= 0) {
                System.out.println("Valor deve ser maior que zero!");
                return;
            }

            if (valor > saldoAtual) {
                System.out.println("Saldo insuficiente! Saldo disponivel: R$ " + String.format("%.2f", saldoAtual));
                return;
            }

            saldoAtual -= valor;
            String dataHora = LocalDateTime.now().format(FORMATTER);
            movimentacoes.add(new String[]{
                "Saque",
                String.format("%.2f", valor),
                dataHora,
                String.format("%.2f", saldoAtual)
            });

            System.out.println("\nSaque de R$ " + String.format("%.2f", valor) + " realizado com sucesso!");
            System.out.println("Saldo atual: R$ " + String.format("%.2f", saldoAtual));

        } catch (NumberFormatException e) {
            System.out.println("Valor invalido! Digite um numero valido.");
        }
    }

    // Exibe o extrato completo com todas as movimentacoes
    static void verExtrato() {
        System.out.println("\n========================================");
        System.out.println("         EXTRATO BANCARIO               ");
        System.out.println("========================================");

        if (movimentacoes.isEmpty()) {
            System.out.println("Nenhuma movimentacao registrada.");
            System.out.println("Saldo atual: R$ " + String.format("%.2f", saldoAtual));
            System.out.println("========================================");
            return;
        }

        double totalEntradas = 0.0;
        double totalSaidas   = 0.0;

        for (int i = 0; i < movimentacoes.size(); i++) {
            String[] mov = movimentacoes.get(i);
            String tipo     = mov[0];  // "Deposito" ou "Saque"
            double valor    = Double.parseDouble(mov[1].replace(",", "."));
            String dataHora = mov[2];
            String saldoPos = mov[3];

            String sinal = tipo.equals("Deposito") ? "+" : "-";

            System.out.printf(
                "%2d. [%s] %s  %sR$ %s  | Saldo: R$ %s%n",
                (i + 1), dataHora, padRight(tipo, 8), sinal, mov[1], saldoPos
            );

            if (tipo.equals("Deposito")) {
                totalEntradas += valor;
            } else {
                totalSaidas += valor;
            }
        }

        System.out.println("----------------------------------------");
        System.out.println("Total de entradas : R$ " + String.format("%.2f", totalEntradas));
        System.out.println("Total de saidas   : R$ " + String.format("%.2f", totalSaidas));
        System.out.println("Saldo atual       : R$ " + String.format("%.2f", saldoAtual));
        System.out.println("========================================");
    }

    // Exibe apenas o saldo atual
    static void verSaldo() {
        System.out.println("\nSaldo atual: R$ " + String.format("%.2f", saldoAtual));
    }

    // Utilitario: preenche string com espacos a direita ate o tamanho dado
    private static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
}
