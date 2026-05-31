import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AbrirConta {

    private static List<String[]> contas = new ArrayList<>();
    private static int proximoNumero = 1;

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
    }

    public static void listarContas() {

        if(contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
            return;
        }

        System.out.println("\n=== CONTAS ===");

        for(String[] conta : contas) {
            System.out.println(
                "Conta: " + conta[0] +
                " | Titular: " + conta[1] +
                " | CPF: " + conta[2]
            );
        }
    }
}