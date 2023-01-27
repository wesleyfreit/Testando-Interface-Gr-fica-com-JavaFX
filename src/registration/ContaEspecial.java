import classe.Conta;

public class ContaEspecial extends Conta {
    private double limite;

    public ContaEspecial() {
    }

    public ContaEspecial(int numero, String nomeTitular, String cpfTitular, double limite) {
        super(numero, nomeTitular, cpfTitular);
        this.limite = limite;
    }

    public double getLimite() {
        return this.limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {
        if (this.limite + this.getSaldo() >= valor) {
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }
        return false;
    }
}