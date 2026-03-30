package account.bank.project.main;

import account.bank.project.Conta.ContaBancaria;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<ContaBancaria> listaDeContas = new ArrayList<>();
        Scanner respostaMenu = new Scanner(System.in);

        int opcao = -1;

        while (opcao != 6) {
            System.out.println
                    ("""
                    ===== MENU DE OPÇÕES BANCÁRIAS =====
                    1. Criar nova conta
                    2. Depositar
                    3. Sacar
                    4. Transferir
                    5. Mostrar dados
                    6. Sair
                    ====================================
                    """);

            switch (opcao) {
                case 1:
                    ContaBancaria conta = new ContaBancaria();
                    System.out.println("Digite o nome do conta: ");
                    conta.setNome(respostaMenu.nextLine());
                    System.out.println("Digite o numero do conta: ");
                    conta.setNumeroDaConta(respostaMenu.nextInt());
                    break;
                case 2:
                    System.out.println("Digite o numero da conta: ");
                    conta.getNumeroDaConta(respostaMenu.nextInt());
            }
        }
        respostaMenu.close();
    }
}
