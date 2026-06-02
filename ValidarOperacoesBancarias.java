public class ValidarOperacoesBancarias {

    public static boolean validarValor(double valor) {
        if (valor <= 0) {
            System.out.println("Valor invalido! Informe um valor maior que zero.");
            return false;
        }

        return true;
    }

    public static boolean validarSaldoSuficiente(double saldoAtual, double valor) {
        if (!validarValor(valor)) {
            return false;
        }

        if (valor > saldoAtual) {
            System.out.println("Saldo insuficiente para realizar a operacao.");
            return false;
        }

        return true;
    }

    public static boolean validarSaldoInicial(double saldoInicial) {
        if (saldoInicial < 0) {
            System.out.println("Saldo inicial invalido! O saldo nao pode ser negativo.");
            return false;
        }

        return true;
    }
}