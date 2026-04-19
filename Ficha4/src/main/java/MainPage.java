import javax.swing.*;

public class MainPage {
    private JPanel mainPage;
    private JPanel sidePanel;
    private Utilizador utilizador;
    private Conta conta;

    // CONSTRUTOR
    public MainPage(Utilizador utilizador) {
        this.utilizador = utilizador;
        this.conta = utilizador.getConta();
        inicializarUI();
    }

    //  GETTER DO PAINEL PRINCIPAL
    public JPanel getMainPanel() {
        return mainPage;
    }

    // INICIALIZAR UI
    private void inicializarUI() {
        if (mainPage == null) {
            mainPage = new JPanel();
        }

        mainPage.removeAll();
        mainPage.setLayout(new BoxLayout(mainPage, BoxLayout.Y_AXIS));

        // ✅ COR DE FUNDO IGUAL AO LOGIN
        mainPage.setBackground(new java.awt.Color(238, 238, 238));  // Cinzento claro (padrão do sistema)
        mainPage.setOpaque(true);  // Garante que a cor é mostrada

        // PAINEL DE BOAS-VINDAS
        JLabel labelBemVindo = new JLabel("Bem-vindo, " + utilizador.getNome() + "!");
        labelBemVindo.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        mainPage.add(Box.createVerticalStrut(15));
        mainPage.add(labelBemVindo);
        mainPage.add(Box.createVerticalStrut(20));

        // INFORMAÇÕES DA CONTA
        JLabel labelConta = new JLabel("Número de Conta: " + conta.getNumConta());
        labelConta.setFont(new java.awt.Font("Arial", 0, 12));
        mainPage.add(labelConta);

        JLabel labelEmail = new JLabel("Email: " + utilizador.getEmail());
        labelEmail.setFont(new java.awt.Font("Arial", 0, 12));
        mainPage.add(labelEmail);

        mainPage.add(Box.createVerticalStrut(15));

        // SALDO
        JLabel labelSaldo = new JLabel("Saldo Actual: " + String.format("%.2f", conta.getSaldo()) + "€");
        labelSaldo.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        mainPage.add(labelSaldo);

        JLabel labelSaldoMin = new JLabel("Saldo Mínimo: " + String.format("%.2f", conta.getSaldoMinimo()) + "€");
        labelSaldoMin.setFont(new java.awt.Font("Arial", 0, 12));
        mainPage.add(labelSaldoMin);

        mainPage.add(Box.createVerticalStrut(20));

        // NÚMERO DE MOVIMENTOS
        JLabel labelMovimentos = new JLabel("Movimentos: " + conta.getNumMovimentos());
        labelMovimentos.setFont(new java.awt.Font("Arial", 0, 12));
        mainPage.add(labelMovimentos);

        mainPage.add(Box.createVerticalStrut(30));

        // BOTÕES DE AÇÕES
        JButton btnAdicionarReceita = new JButton("Adicionar Receita");
        btnAdicionarReceita.setMaximumSize(new java.awt.Dimension(200, 30));
        btnAdicionarReceita.addActionListener(e -> adicionarReceita());
        mainPage.add(btnAdicionarReceita);

        mainPage.add(Box.createVerticalStrut(10));

        JButton btnAdicionarDespesa = new JButton("Adicionar Despesa");
        btnAdicionarDespesa.setMaximumSize(new java.awt.Dimension(200, 30));
        btnAdicionarDespesa.addActionListener(e -> adicionarDespesa());
        mainPage.add(btnAdicionarDespesa);

        mainPage.add(Box.createVerticalStrut(10));

        JButton btnListarMovimentos = new JButton("Listar Movimentos");
        btnListarMovimentos.setMaximumSize(new java.awt.Dimension(200, 30));
        btnListarMovimentos.addActionListener(e -> listarMovimentos());
        mainPage.add(btnListarMovimentos);

        mainPage.add(Box.createVerticalStrut(10));

        JButton btnDefinirSaldoMinimo = new JButton("Definir Saldo Mínimo");
        btnDefinirSaldoMinimo.setMaximumSize(new java.awt.Dimension(200, 30));
        btnDefinirSaldoMinimo.addActionListener(e -> definirSaldoMinimo());
        mainPage.add(btnDefinirSaldoMinimo);

        mainPage.add(Box.createVerticalStrut(10));

        JButton btnLogout = new JButton("Logout");
        btnLogout.setMaximumSize(new java.awt.Dimension(200, 30));
        btnLogout.addActionListener(e -> logout());
        mainPage.add(btnLogout);

        mainPage.add(Box.createVerticalGlue());
    }

    //AÇÕES DOS BOTÕES

    private void adicionarReceita() {
        String descricao = JOptionPane.showInputDialog(mainPage,
                "Descrição da receita:",
                "Adicionar Receita",
                JOptionPane.QUESTION_MESSAGE);

        if (descricao == null || descricao.isEmpty()) {
            return;
        }

        String valorStr = JOptionPane.showInputDialog(mainPage,
                "Valor da receita (em €):",
                "Adicionar Receita",
                JOptionPane.QUESTION_MESSAGE);

        if (valorStr == null || valorStr.isEmpty()) {
            return;
        }

        try {
            double valor = Double.parseDouble(valorStr);
            if (valor <= 0) {
                JOptionPane.showMessageDialog(mainPage,
                        "O valor deve ser positivo!",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            conta.adicionarMovimentoReceita(descricao, valor);
            JOptionPane.showMessageDialog(mainPage,
                    "Receita adicionada com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);

            // Atualizar interface
            inicializarUI();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(mainPage,
                    "Valor inválido! Use formato: 10.50",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void adicionarDespesa() {
        String descricao = JOptionPane.showInputDialog(mainPage,
                "Descrição da despesa:",
                "Adicionar Despesa",
                JOptionPane.QUESTION_MESSAGE);

        if (descricao == null || descricao.isEmpty()) {
            return;
        }

        String valorStr = JOptionPane.showInputDialog(mainPage,
                "Valor da despesa (em €):",
                "Adicionar Despesa",
                JOptionPane.QUESTION_MESSAGE);

        if (valorStr == null || valorStr.isEmpty()) {
            return;
        }

        try {
            double valor = Double.parseDouble(valorStr);
            if (valor <= 0) {
                JOptionPane.showMessageDialog(mainPage,
                        "O valor deve ser positivo!",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            conta.adicionarMovimentoDespesa(descricao, valor);
            JOptionPane.showMessageDialog(mainPage,
                    "Despesa adicionada com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);

            // Atualizar interface
            inicializarUI();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(mainPage,
                    "Valor inválido! Use formato: 10.50",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listarMovimentos() {
        System.out.println("\n========== MOVIMENTOS DO UTILIZADOR ==========");
        System.out.println("Nome: " + utilizador.getNome());
        System.out.println("Conta: " + conta.getNumConta());
        System.out.println("=".repeat(50));

        conta.listarMovimentos();

        JOptionPane.showMessageDialog(mainPage,
                "Movimentos listados na consola!\nTotal: " + conta.getNumMovimentos(),
                "Movimentos",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void definirSaldoMinimo() {
        String valorStr = JOptionPane.showInputDialog(mainPage,
                "Novo saldo mínimo (em €):",
                "Definir Saldo Mínimo",
                JOptionPane.QUESTION_MESSAGE);

        if (valorStr == null || valorStr.isEmpty()) {
            return;
        }

        try {
            double valor = Double.parseDouble(valorStr);
            if (valor < 0) {
                JOptionPane.showMessageDialog(mainPage,
                        "O valor não pode ser negativo!",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            conta.setSaldoMinimo(valor);
            JOptionPane.showMessageDialog(mainPage,
                    "Saldo mínimo definido para: " + valor + "€",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);

            // Atualizar interface
            inicializarUI();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(mainPage,
                    "Valor inválido! Use formato: 10.50",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void logout() {
        int opcao = JOptionPane.showConfirmDialog(mainPage,
                "Tem certeza que deseja fazer logout?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION);

        if (opcao == JOptionPane.YES_OPTION) {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(mainPage);
            if (frame != null) {
                frame.dispose();
            }

            // Reabrir Login
            JFrame frameLogin = new JFrame("Login - Gestão de Finanças");
            frameLogin.setContentPane(new Login().panelLogin);
            frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameLogin.pack();
            frameLogin.setLocationRelativeTo(null);
            frameLogin.setVisible(true);
        }
    }


    public static void main(String[] args) {
        Utilizador user = new Utilizador("trust", "O menor", "zezocas@gmail.pt",
                "Macaco", "Toy", "Bananas");

        user.getConta().setSaldo(1000.0);
        user.getConta().setSaldoMinimo(200.0);

        MainPage mainPage = new MainPage(user);
        JFrame frame = new JFrame("Main Page - Gestão de Finanças");
        frame.setContentPane(mainPage.getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
