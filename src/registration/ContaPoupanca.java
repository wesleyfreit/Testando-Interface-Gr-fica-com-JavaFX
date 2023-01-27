import classe.Conta;

public class ContaPoupanca extends Conta {

    public ContaPoupanca() {
    }

    public ContaPoupanca(int numero, String nomeTitular, String cpfTitular) {
        super(numero, nomeTitular, cpfTitular);
    }

    public void rejustar(double percentual) {
        double reajuste = this.getSaldo() * percentual;
        this.depositar(reajuste);
    }

    @Override
    public boolean sacar(double valor) {
        if (this.getSaldo() >= valor) {
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }
        return false;
    }
}