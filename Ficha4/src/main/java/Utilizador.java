import java.util.concurrent.ThreadLocalRandom;

public class Utilizador {
    private String nome;
    private String ultNome;
    private String verificacaoCC; //Bitmap
    private String email;
    private String username;
    private String password;
    private long numConta;

    public Utilizador(String password, String username, String email, String verificacaoCC, String ultNome, String nome) {
        this.password = password;
        this.username = username;
        this.email = email;
        this.verificacaoCC = verificacaoCC;
        this.ultNome = ultNome;
        this.nome = nome;
        setNumConta();
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

    private void setNumConta() {
        //TODO rand numConta
        long min = 1000000000L;
        long max = 9999999999L;
        this.numConta = ThreadLocalRandom.current().nextLong(min, max+1);
    }

    public void Login(String username,String password){
        long conta=getNumConta();

    }
}
