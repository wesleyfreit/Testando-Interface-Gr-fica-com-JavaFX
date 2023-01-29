package functions;

import classes.Conta;

public class ContaCorrente extends Conta {
    final static String tipoConta = "Conta Corrente";

    public String getTipoConta() {
        return tipoConta;
    }

    public ContaCorrente() {
    }

    public ContaCorrente(int id, String numero, String nomeTitular, String cpfTitular) {
        super(id, numero, nomeTitular, cpfTitular, tipoConta);
    }
}