import javax.swing.*;

public class Login {
    public JPanel panelLogin;
    private JTextArea passwordTextArea;
    private JPasswordField passwordTxt;
    private JButton recuperarPasswordButton;
    private JButton loginButton;

    private Utilizador utilizadorLogado;


    public Login() {
        recuperarPasswordButton.addActionListener(e -> {
            recuperarPassword();
        });

        loginButton.addActionListener(e -> {
            fazerLogin();
        });
    }

    // LÓGICA DE LOGIN
    private void fazerLogin() {
        // 1. Recolher dados dos campos
        String username = passwordTextArea.getText().trim();
        String password = new String(passwordTxt.getPassword()).trim();

        // 2. Validar se os campos estão preenchidos
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(panelLogin,
                    "Por favor, preencha username e password!",
                    "Campos Vazios",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 3. Criar um utilizador para teste (simplificado)

        Utilizador utilizadorTeste = new Utilizador(
                "a",           // password
                "a",         // username
                "zezocas@gmail.pt",// email
                "Macaco",          // verificacaoCC
                "Toy",             // ultNome
                "Bananas"          // nome
        );

        // 4. Validar credenciais
        if (utilizadorTeste.validarLogin(username, password)) {
            this.utilizadorLogado = utilizadorTeste;
            JOptionPane.showMessageDialog(panelLogin,
                    "Login bem-sucedido!\nBem-vindo, " + utilizadorTeste.getNome() + "!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);

            // 5. Abrir MainPage
            abrirMainPage(utilizadorTeste);

            // 6. Fechar janela de login
            fecharLogin();
        } else {
            JOptionPane.showMessageDialog(panelLogin,
                    "Username ou password incorreto!",
                    "Erro de Autenticação",
                    JOptionPane.ERROR_MESSAGE);

            // Limpar campos
            limparCampos();
        }
    }

    //LÓGICA DE RECUPERAÇÃO DE PASSWORD
    private void recuperarPassword() {
        String email = JOptionPane.showInputDialog(panelLogin,
                "Introduza o seu email:",
                "Recuperar Password",
                JOptionPane.QUESTION_MESSAGE);

        if (email != null && !email.isEmpty()) {
            JOptionPane.showMessageDialog(panelLogin,
                    "Email de recuperação enviado para: " + email,
                    "Recuperação",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //MÉTODOS AUX
    private void limparCampos() {
        passwordTextArea.setText("");
        passwordTxt.setText("");
        passwordTextArea.requestFocus();
    }


    private void abrirMainPage(Utilizador utilizador) {
        // Abrir a janela MainPage
        MainPage mainPage = new MainPage(utilizador);
        JFrame frameMain = new JFrame("Main Page - Gestão de Finanças");
        frameMain.setContentPane(mainPage.getMainPanel());
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.pack();
        frameMain.setLocationRelativeTo(null);
        frameMain.setVisible(true);
    }

    private void fecharLogin() {
        // Fechar janela de login
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panelLogin);
        if (frame != null) {
            frame.dispose();
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Login - Gestão de Finanças");
        frame.setContentPane(new Login().panelLogin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);  // Centrar na tela
        frame.setVisible(true);
    }
}
