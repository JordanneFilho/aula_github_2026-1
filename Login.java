import java.util.Scanner;

public class BancoApp {

    public static void main(String[] args) {

        String usuarioCorreto = "lucas";
        String senhaCorreta = "123456";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Usuário: ");
        String usuario = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        if (usuario.equals(usuarioCorreto) && senha.equals(senhaCorreta)) {
            System.out.println("Login realizado com sucesso!");
            System.out.println("Bem-vindo ao Banco XYZ.");
        } else {
            System.out.println("Usuário ou senha inválidos.");
        }

        scanner.close();
    }
}