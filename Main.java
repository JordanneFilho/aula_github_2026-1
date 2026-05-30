import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int opcao = 0;

        do {
            Menu mainMenu = new Menu("Menu Principal", Arrays.asList(
                "Cliente",
                "Saque",
                "Sair"
            ));
            opcao = mainMenu.getSelection();

            switch (opcao) {
                case 1:
                    CadastrarCliente.menu();
                    break;
                case 2:
                    RealizarSaque.menu();
                    break;
                case 3:
                    System.out.println("Encerrando sistema...");
                    break;
            }

        } while (opcao != 3);
    }
}