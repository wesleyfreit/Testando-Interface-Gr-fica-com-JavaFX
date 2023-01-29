package controller;

import java.util.List;

import classes.Conta;
import functions.ContaCorrente;
import functions.ContaPoupanca;

public class DadosTest {
    public static int create(){
        List<Conta> accounts = ListDados.getAccounts();

        ContaPoupanca cadastroPoupança1 = new ContaPoupanca(1, "02158-2", "Antonio Gobira Da Silva", "129.479.749-47", 1105.84);
        ContaPoupanca cadastroPoupança2 = new ContaPoupanca(2, "51518-2", "José Nascimento Santana", "089.214.714-17",2625.99);
        ContaCorrente cadastroCorrente1 = new ContaCorrente(3, "21215-6", "Mario Gomes Alencar", "032.795.324-25");
        ContaCorrente cadastroCorrente2 = new ContaCorrente(4, "02519-1", "Airton Bezzera Alves", "021.654.241-26");

        accounts.add(cadastroPoupança1);
        accounts.add(cadastroPoupança2);
        accounts.add(cadastroCorrente1);
        accounts.add(cadastroCorrente2);


        return 5;
    }
}
