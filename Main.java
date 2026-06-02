import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int opcao = 0;

        do {
            Menu mainMenu = new Menu("Menu Principal", Arrays.asList(
                "Cliente",
                "Conta",
                "Saque",
                "Extrato",
                "Encerrar Conta",
                "Sair"
            ));
            opcao = mainMenu.getSelection();

            switch (opcao) {
                case 1:
                    CadastrarCliente.menu();
                    break;
                case 2:
                    AbrirConta.menu();
                    break;
                case 3:
                    RealizarSaque.menu();
                    break;
                case 4:
                    ExtratosBancarios.menu();
                    break;
                case 5:
                    EncerrarConta.menu();
                    break;
                case 6:
                    System.out.println("Encerrando sistema...");
                    break;
            }
        } while (opcao != 6);
    }
}