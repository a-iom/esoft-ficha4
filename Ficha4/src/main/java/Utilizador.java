import java.util.concurrent.ThreadLocalRandom;

public class Utilizador {
    private String nome;
    private String ultNome;
    private String verificacaoCC; //Bitmap
    private String email;
    private String username;
    private String password;
    private long numConta;
    private Conta conta; // relação com Conta

    public Utilizador(String password, String username, String email,
                      String verificacaoCC, String ultNome, String nome) {
        this.password = password;
        this.username = username;
        this.email = email;
        this.verificacaoCC = verificacaoCC;
        this.ultNome = ultNome;
        this.nome = nome;
        setNumConta();
        this.conta = new Conta(this.numConta); // cria conta automaticamente
    }

    public String getNome() {
        return nome;
    }

    public String getUltNome() {
        return ultNome;
    }

    private String getVerificacaoCC() {
        return verificacaoCC;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    private String getPassword() {
        return password;
    }

    public long getNumConta() {
        return numConta;
    }

    public Conta getConta() {
        return conta;
    }

    private void setNumConta() {
        //TODO rand numConta
        long min = 1000000000L;
        long max = 9999999999L;
        this.numConta = ThreadLocalRandom.current().nextLong(min, max+1);
    }


    // Validar Login
    public boolean validarLogin(String username, String password) {
        // Comparar username E password recebidos com os armazenados
        return this.username.equals(username) && this.password.equals(password);
    }

    // Método Login completo
    public boolean login(String username, String password) {
        if (validarLogin(username, password)) {
            System.out.println("Login bem-sucedido para: " + this.username);
            return true;
        } else {
            System.out.println("Credenciais inválidas!");
            return false;
        }
    }

    // ToString para debug
    @Override
    public String toString() {
        return "Utilizador{" +
                "nome='" + nome + '\'' +
                ", ultNome='" + ultNome + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", numConta=" + numConta +
                '}';
    }
}
