package functions;

import classes.Conta;

public class ContaPoupanca extends Conta {
    final static String tipoConta = "Conta Poupança";

    public String getTipoConta() {
        return tipoConta;
    }

    public ContaPoupanca() {
    }

    public ContaPoupanca(int id, String numero, String nomeTitular, String cpfTitular, double saldo) {
        super(id, numero, nomeTitular, cpfTitular, tipoConta, saldo);
    }
}