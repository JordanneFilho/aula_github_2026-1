public class Conta {

    private double saldo;

    public Conta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito realizado com sucesso!");
    }

    public void exibirSaldo() {
        System.out.println("Saldo atual: R$ " + saldo);
    }

    public static void main(String[] args) {

        Conta conta = new Conta(1000);

        conta.exibirSaldo();

        conta.depositar(500);

        conta.exibirSaldo();
    }
}