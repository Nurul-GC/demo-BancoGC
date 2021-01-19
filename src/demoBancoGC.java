import java.util.Scanner;
import classes.BancoGC;

/************************************************
 * Direitos Autorais (c) 2019-2021. Nurul GC    *
 *
 * Jovem Programador                            *
 * Estudante de Engenharia de Telecomunicações  *
 * Tecnologia de Informação e de Medicina       *
 * Fé Foco Força Paciência                      *
 * Allah no Comando.                            *
 ************************************************/

public class demoBancoGC extends BancoGC{
    public static void main(String[] args){
        BancoGC novaConta = new BancoGC();
        Scanner input = new Scanner(System.in);

        System.out.printf("""
%n
***************************************************************************
*                        *** BancoGC ***                                  *
*                                                                         *
*                        Ola caro cliente                                 *
*   Nos temos o prazer de oferecer-lhe a oportunidade                     *
*   de criar diversos planos com seu dinheiro.                            *
*   Sem ter que se preocupar com dividas ou contas para pagar.            *
*   Todas as contas criadas em nosso banco sao do tipo poupanca           *
*   facilitando entao a estabilidade e crescimento economico do cliente   *
*                                                                         *
*   Vamos iniciar o nosso processo de cadastro..                          *
***************************************************************************
""");
        do {
            System.out.println("\nDigite o seu nome:");
            System.out.print("> ");
            novaConta.nomeTitular = input.nextLine();

            System.out.println("\nDigite o valor a depositar:");
            System.out.print("> ");
            novaConta.saldo = input.nextDouble();

            if ((novaConta.nomeTitular.isEmpty() | novaConta.nomeTitular.isBlank()) | (novaConta.saldo < 1)) {
                System.out.print("\n[!] Por Favor Introduza dados validos..\nEXEMPLO\nNome: Antonio Fulano\nValor a depositar: maior 0\n");
            }
            else {
                System.out.println("\nParabens " + novaConta.nomeTitular + " a sua conta foi criada com sucesso..");
                System.out.print("""
                        *********************************************************
                        * Para ter acesso aos seus dados use os digitos chaves: *
                        *      [1] - EXTRATO;        [3] - LEVANTAR;            *
                        *      [2] - DEPOSITAR;      [s] - SAIR;                *
                        *********************************************************
                        """);
                do {
                    String acesso = input.nextLine();

                    if (acesso.equals("1")) {
                        novaConta.extrato();
                    }
                    if (acesso.equals("2")) {
                        System.out.println("\nDigite o valor a depositar: ");
                        System.out.print("> ");
                        double deposito = input.nextDouble();
                        novaConta.depositar(deposito);
                        continue;
                    }
                    if (acesso.equals("3")) {
                        System.out.println("\nDigite o valor a levantar: ");
                        System.out.print("> ");
                        double levantamento = input.nextDouble();
                        novaConta.levantar(levantamento);
                        continue;
                    }
                    if (acesso.equals("s")) {
                        System.out.println("\nObrigado pela preferencia..\nTerminando o programa!");
                        System.exit(0);
                    }
                    System.out.println("\n*** [1]-[2]-[3]-[s] ***");
                    System.out.print("> ");
                } while (true);
            }
        }
        while (true);
    }
}
