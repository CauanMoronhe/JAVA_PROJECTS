package account.bank.project.Conta;

import account.bank.project.Calculos.Operacoes;

public class ContaBancaria extends Operacoes {
    protected String nome;
    protected int numeroDaConta;
    protected double saldo = 0;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroDaConta(int numeroDaConta) {
        return numeroDaConta;
    }

    public void mostrarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Numero da conta: " + this.numeroDaConta);
        System.out.println("Saldo da conta: " + this.saldo);
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + ", " + "Numero da conta: " + this.numeroDaConta + ", " + "Saldo: " + this.saldo;
    }
}
