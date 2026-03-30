package account.bank.project.Calculos;

public class Operacoes {
    private double saldo;

    public void saque(double quantidade) {
        if (quantidade < saldo) {
            System.out.println("Amount to withdraw is less than your balance");
        } else {
            saldo = saldo - quantidade;
        }
    }

    public void depositar(double quantidade) {
        saldo = saldo + quantidade;
    }
}
