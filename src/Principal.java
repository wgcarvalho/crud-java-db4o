
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Video Aulas
 */
public class Principal {

    private static Conexao c = null;
    private static Pessoa p = null;
    private static List<Pessoa> lp = null;
    private static int opcao = 0;
    private static Scanner entrada = new Scanner(System.in);
    private static int rg, idade;
    private static String nome;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        do {
            System.out.println("Observe o menu abaixo e escolha uma das opções");
            System.out.println("1 - Gravar novo registro;");
            System.out.println("2 - Exibir todos os registros;");
            System.out.println("3 - Exibir registro individual;");
            System.out.println("4 - Alterar informações no registro;");
            System.out.println("5 - Apagar registro;");
            System.out.println("6 - Sair.");
            System.out.println("Informe o número da opção desejada");
            opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    gravarPessoa();
                    break;
                case 2:
                    exibirTodos();
                    break;
                case 3:
                    exibirRegistro();
                    break;
                case 4:
                    alterarDados();
                    break;
                case 5:
                    apagarRegistro();
                    break;
                case 6:
                    System.out.println("Finalizar aplicação.");
                    break;
                default:
                    System.out.println("Valor não correspondente.");
            }
        } while (opcao != 6);
    }

    private static void gravarPessoa() {
        c = new Conexao();
        p = new Pessoa();
        Scanner entradaTexto = new Scanner(System.in);
        System.out.println("Gravar novo registro:");
        System.out.println("informe o rg da pessoa:");
        rg = entrada.nextInt();
        System.out.println("informe o nome da pessoa:");
        nome = entradaTexto.nextLine();
        System.out.println("informe a idade da pessoa:");
        idade = entrada.nextInt();
        p.setRg(rg);
        p.setNome(nome);
        p.setIdade(idade);
        c.insertPessoa(p);
    }

    private static void exibirTodos() {
        c = new Conexao();
        System.out.println("Todos os registros cadastradados:");
        lp = c.selectAllPessoa();
        for (Pessoa lp1 : lp) {
            System.out.println(lp1);
        }
    }
    
    private static void exibirRegistro(){
        c = new Conexao();
        p = new Pessoa();
        System.out.println("Exibir registro escolhido:");
        System.out.println("Informe o RG da pessoa:");
        rg = entrada.nextInt();
        p.setRg(rg);
        Pessoa presult = c.selectPessoa(p);
        System.out.println(presult);
    }
    
    private static void alterarDados(){
        c = new Conexao();
        Scanner entradaTexto = new Scanner(System.in);
        System.out.println("Alterar dados do registro cadastrado:");
        System.out.println("Informe o número do RG da pessoa ");
        rg = entrada.nextInt();
        System.out.println("Informe o nome alterado:");
        nome = entradaTexto.nextLine();
        System.out.println("Informe a idade alterada:");
        idade = entrada.nextInt();
        c.updatePessoa(rg, nome, idade);
    }
    
    private static void apagarRegistro(){
        c = new Conexao();
        System.out.println("Apagar um dos registro:");
        System.out.println("Informe o número do RG escolhido para apagar:");
        rg = entrada.nextInt();
        c.deletePessoa(rg);
    }
}
