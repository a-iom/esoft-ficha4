import java.util.LinkedList;
import java.util.List;

public class Conta {
    private long numConta;
    private List<String> movimentos;  // Simples: armazena texto
    private double saldo;
    private double saldoMinimo;

    public Conta(long numConta) {
        this.numConta = numConta;
        this.movimentos = new LinkedList<>();
        this.saldo = 0.0;
        this.saldoMinimo = 0.0;
    }

    // GETTERS
    public long getNumConta() {
        return numConta;
    }

    public List<String> getMovimentos() {
        return movimentos;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getSaldoMinimo() {
        return saldoMinimo;
    }

    public int getNumMovimentos() {
        return movimentos.size();
    }

    // SETTERS
    public void setSaldoMinimo(double saldoMinimo) {
        if (saldoMinimo >= 0) {
            this.saldoMinimo = saldoMinimo;
            System.out.println("Saldo mínimo definido para: " + saldoMinimo + "€");
        } else {
            System.out.println("Saldo mínimo não pode ser negativo!");
        }
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
            System.out.println("Saldo definido para: " + saldo + "€");
        } else {
            System.out.println("Saldo não pode ser negativo!");
        }
    }

    // ADICIONAR MOVIMENTO (Simples - Despesa)
    public void adicionarMovimentoDespesa(String descricao, double valor) {
        if (valor < 0) {
            System.out.println("Valor não pode ser negativo!");
            return;
        }

        this.saldo -= valor;
        String movimento = "[-] " + descricao + " : " + valor + "€";
        movimentos.add(movimento);
        System.out.println("Despesa adicionada: " + descricao + " - " + valor + "€");
        System.out.println("Saldo atual: " + this.saldo + "€");
        verificarSaldoMinimo();
    }

    // ADICIONAR MOVIMENTO (Simples - Receita)
    public void adicionarMovimentoReceita(String descricao, double valor) {
        if (valor < 0) {
            System.out.println("Valor não pode ser negativo!");
            return;
        }

        this.saldo += valor;
        String movimento = "[+] " + descricao + " : " + valor + "€";
        movimentos.add(movimento);
        System.out.println("Receita adicionada: " + descricao + " - " + valor + "€");
        System.out.println("Saldo atual: " + this.saldo + "€");
    }

    // REMOVER MOVIMENTO
    public boolean removerMovimento(int indice) {
        if (indice < 0 || indice >= movimentos.size()) {
            System.out.println("Índice inválido!");
            return false;
        }

        String movimento = movimentos.get(indice);
        movimentos.remove(indice);

        // Recalcular saldo
        recalcularSaldo();

        System.out.println("Movimento removido: " + movimento);
        verificarSaldoMinimo();
        return true;
    }

    // RECALCULAR SALDO
    private void recalcularSaldo() {
        this.saldo = 0.0;
        for (String mov : movimentos) {
            // Extrair valor do movimento
            int inicio = mov.lastIndexOf(":") + 2;
            int fim = mov.lastIndexOf("€");
            String valorStr = mov.substring(inicio, fim).trim();
            double valor = Double.parseDouble(valorStr);

            // Se é receita (+) soma, se é despesa (-) subtrai
            if (mov.startsWith("[+]")) {
                this.saldo += valor;
            } else {
                this.saldo -= valor;
            }
        }
        System.out.println("Saldo recalculado: " + this.saldo + "€");
    }

    // VERIFICAR SALDO MÍNIMO
    private void verificarSaldoMinimo() {
        if (this.saldo < this.saldoMinimo) {
            System.out.println("ALERTA: Saldo baixo! (" + this.saldo + "€ < " +
                    this.saldoMinimo + "€)");
        }
    }

    // LISTAR MOVIMENTOS
    public void listarMovimentos() {
        if (movimentos.isEmpty()) {
            System.out.println("Sem movimentos registados.");
            return;
        }

        System.out.println("\n--- MOVIMENTOS DA CONTA " + numConta + " ---");
        for (int i = 0; i < movimentos.size(); i++) {
            System.out.println((i + 1) + ". " + movimentos.get(i));
        }
        System.out.println("Saldo Total: " + this.saldo + "€");
        System.out.println("-----------------------------------\n");
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numConta=" + numConta +
                ", saldo=" + saldo +
                ", saldoMinimo=" + saldoMinimo +
                ", movimentos=" + movimentos.size() +
                '}';
    }
}