public class Main {
    public static void main(String[] args) {
        System.out.println("=== TESTE DA CLASSE UTILIZADOR ===\n");

        // CRIAR UM UTILIZADOR
        System.out.println("CRIAR UTILIZADOR");
        Utilizador user1 = new Utilizador(
                "trust",           // password
                "O menor",         // username
                "zezocas@gmail.pt",// email
                "Macaco",          // verificacaoCC
                "Toy",             // ultNome
                "Bananas"          // nome
        );
        System.out.println(user1);
        System.out.println();

        //TESTAR GETTERS
        System.out.println("TESTE GETTERS");
        System.out.println("Nome: " + user1.getNome());
        System.out.println("Apelido: " + user1.getUltNome());
        System.out.println("Email: " + user1.getEmail());
        System.out.println("Username: " + user1.getUsername());
        System.out.println("Número de Conta: " + user1.getNumConta());
        System.out.println();

        //TESTAR LOGIN COM CREDENCIAIS CORRETAS
        System.out.println("TESTE LOGIN - CREDENCIAIS CORRETAS");
        boolean resultado1 = user1.login("O menor", "trust");
        System.out.println("Resultado: " + resultado1);
        System.out.println();

        //TESTAR LOGIN COM PASSWORD ERRADA
        System.out.println("TESTE LOGIN - PASSWORD ERRADA");
        boolean resultado2 = user1.login("O menor", "senhaerrada");
        System.out.println("Resultado: " + resultado2);
        System.out.println();

        //TESTAR LOGIN COM USERNAME ERRADO
        System.out.println("TESTE LOGIN - USERNAME ERRADO");
        boolean resultado3 = user1.login("Usuario invalido", "trust");
        System.out.println("Resultado: " + resultado3);
        System.out.println();

        //TESTAR VALIDAÇÃO DE LOGIN (método separado)
        System.out.println("TESTE VALIDAÇÃO - CREDENCIAIS CORRETAS");
        boolean validacao1 = user1.validarLogin("O menor", "trust");
        System.out.println("Validação OK: " + validacao1);
        System.out.println();

        //TESTAR VALIDAÇÃO DE LOGIN (credenciais erradas)
        System.out.println("TESTE VALIDAÇÃO - CREDENCIAIS ERRADAS");
        boolean validacao2 = user1.validarLogin("O menor", "errada");
        System.out.println("Validação OK: " + validacao2);
        System.out.println();

        //TESTAR RELAÇÃO COM CONTA
        System.out.println("TESTE RELAÇÃO COM CONTA");
        Conta conta = user1.getConta();  // ✅ PRIMEIRA VEZ - com "Conta"
        System.out.println("Conta obtida: " + conta);
        System.out.println("Número de conta vinculada: " + conta.getNumConta());
        System.out.println();

        // CRIAR MÚLTIPLOS UTILIZADORES
        System.out.println("CRIAR MÚLTIPLOS UTILIZADORES");
        Utilizador user2 = new Utilizador("senha123", "joao", "joao@email.com", "123456", "Silva", "João");
        Utilizador user3 = new Utilizador("pass456", "maria", "maria@email.com", "654321", "Santos", "Maria");

        System.out.println(user2);
        System.out.println(user3);
        System.out.println();

        // ============================================
        // TESTES DA CLASSE CONTA
        // ============================================
        System.out.println("\n=== TESTE DA CLASSE CONTA ===\n");

        // OBTER CONTA DO UTILIZADOR
        System.out.println("OBTER CONTA DO UTILIZADOR");
        conta = user1.getConta();  // ✅ SEGUNDA VEZ - SEM "Conta"
        System.out.println(conta);
        System.out.println();

        // DEFINIR SALDO INICIAL
        System.out.println("DEFINIR SALDO INICIAL");
        conta.setSaldo(1000.0);
        System.out.println();

        // DEFINIR SALDO MÍNIMO
        System.out.println("DEFINIR SALDO MÍNIMO");
        conta.setSaldoMinimo(200.0);
        System.out.println();

        // ADICIONAR MOVIMENTOS
        System.out.println("ADICIONAR MOVIMENTOS");
        conta.adicionarMovimentoReceita("Ordenado mensal", 1500.0);
        System.out.println();

        conta.adicionarMovimentoDespesa("Supermercado", 50.0);
        System.out.println();

        conta.adicionarMovimentoDespesa("Passe de autocarro", 30.0);
        System.out.println();

        conta.adicionarMovimentoDespesa("Café", 25.0);
        System.out.println();

        conta.adicionarMovimentoDespesa("Cinema", 100.0);
        System.out.println();

        // LISTAR MOVIMENTOS
        System.out.println("LISTAR MOVIMENTOS");
        conta.listarMovimentos();

        // INFORMAÇÕES DA CONTA
        System.out.println("INFORMAÇÕES DA CONTA");
        System.out.println("Número de Conta: " + conta.getNumConta());
        System.out.println("Saldo Atual: " + conta.getSaldo() + "€");
        System.out.println("Saldo Mínimo: " + conta.getSaldoMinimo() + "€");
        //System.out.println("Número de Movimentos: " + conta.getNumMovimentos());
        System.out.println();

        // REMOVER MOVIMENTO
        System.out.println("REMOVER MOVIMENTO (índice 0)");
        conta.removerMovimento(0);
        System.out.println();

        // LISTAR NOVAMENTE
        System.out.println("LISTAR APÓS REMOÇÃO");
        conta.listarMovimentos();

        // TESTAR ALERTA DE SALDO BAIXO
        System.out.println("TESTE ALERTA DE SALDO BAIXO");
        conta.adicionarMovimentoDespesa("Despesa grande", 1500.0);
        System.out.println();

        // TESTAR LOGIN MÚLTIPLOS UTILIZADORES
        System.out.println("TESTE LOGIN MÚLTIPLOS UTILIZADORES");
        System.out.println("Joao login: " + user2.login("joao", "senha123"));
        System.out.println("Maria login: " + user3.login("maria", "pass456"));
        System.out.println();

        System.out.println("*/*/*/**/*/*TESTES CONCLUÍDOS");
    }
}
