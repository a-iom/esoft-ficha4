import java.util.LinkedList;

public class Conta {
    private long numConta;
    private LinkedList movimentos;
    private double saldo;
    private double saldoMinimo;

    public Conta(long numConta) {
        this.numConta = numConta;
    }

    public long getNumConta() {
        return numConta;
    }

    public LinkedList getMovimentos() {
        return movimentos=new LinkedList();
    }

    public double getSaldo() {
        return saldo;
    }

    public double getSaldoMinimo() {
        return saldoMinimo;
    }

    public void adicionarMovimento(LinkedList movimentos){

    }
}
