package classes;

import classes.interfaces.MetodoDeposito;
import classes.interfaces.MetodoSaque;

public abstract class Conta implements MetodoSaque, MetodoDeposito {
    private int id;
    private String numero;
    private double saldo;
    private Cliente titular;
    private String tipoConta;

    public Conta() {
    }

    public Conta(int id, String numero, String nomeTitular, String cpfTitular, String tipoconta) {
        this.id = id;
        this.numero = numero;
        this.tipoConta = tipoconta;
        this.titular = new Cliente(nomeTitular, cpfTitular);
    }

    public Conta(int id, String numero, String nomeTitular, String cpfTitular, String tipoconta, double saldo) {
        this(id, numero, nomeTitular, cpfTitular, tipoconta);
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    @Override
    public boolean sacar(double valor) {
        if (this.getSaldo() >= valor) {
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }
        return false;
    }

    @Override
    public boolean depositar(double valor) {
        this.saldo = this.getSaldo() + valor;
        return true;
    }

}
