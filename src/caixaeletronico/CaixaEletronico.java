/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixaeletronico;

/**
 *
 * @author User
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaixaEletronico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean d;
        double valor;
        int quantidade , bandejaNumero , opcao;
        

        Scanner entrada = new Scanner(System.in);
        Bandeja b1 = new Bandeja(100, 600);
        Bandeja b2 = new Bandeja(50, 600);
        Bandeja b3 = new Bandeja(20, 600);
        Bandeja b4 = new Bandeja(5, 600);

        System.out.println("Digite o codigo do caixa 2 Letras e 3 numeros");
        String codigo = entrada.nextLine();

        d = Pattern.matches("^[aA-zZ]{2}[0-9]{3}$", codigo);

        codigo = VerificaCodigo(d, codigo, entrada);

        System.out.println("Digite o Bairro ");
        String bairro = entrada.nextLine();

        System.out.println("Digite a Rua ");
        String rua = entrada.nextLine();

        System.out.println("Digite o Numero \n");
        String numero = entrada.nextLine();

        System.out.println("Digite a Cidade");
        String cidade = entrada.nextLine();

        System.out.println("Digite o Estado");
        String estado = entrada.nextLine();

        Caixa4Bandejas caixa4B = new Caixa4Bandejas(codigo, bairro, rua, numero, cidade, estado, b1, b2, b3, b4);

        do {

            opcao = Menu(entrada);

            switch (opcao) {

                case 1:
                    System.out.println("Digite o valor do Saque , Trabalhamos com notas de 100 , 50 , 20 , 5");
                    valor = entrada.nextDouble();

                    if (caixa4B.verificaSaque(valor)) {
                        System.out.println("Saque bem sucedido \n");
                        System.out.println("Quantidades de notas de R$ 100 = " + caixa4B.getQuantidades()[0]);
                        System.out.println("Quantidades de notas de R$ 50 = " + caixa4B.getQuantidades()[1]);
                        System.out.println("Quantidades de notas de R$ 20 = " + caixa4B.getQuantidades()[2]);
                        System.out.println("Quantidades de notas de R$ 5 = " + caixa4B.getQuantidades()[3]);
                    } else {

                        System.out.println("Valor Digitado "
                                + "incorreto ou nao temos notas necessarias para efetuar o saque \n");
                    }

                    break;

                case 2:
                    System.out.println("Saldo do Caixa = R$" + caixa4B.saldoTotal());
                    break;

                case 3:
                    System.out.println("Informe a Bandeja que deseja verificar o saldo 1 = Notas 100 , 2 = Notas 50 , "
                            + "3 = Notas 20 , 4 = Notas 5");
                    bandejaNumero = entrada.nextInt();

                    switch (bandejaNumero) {
                        case 1:
                            System.out.println("Saldo = R$" + caixa4B.saldoBandeja(b1));
                            break;

                        case 2:
                            System.out.println("Saldo = R$" + caixa4B.saldoBandeja(b2));
                            break;

                        case 3:
                            System.out.println("Saldo = R$" + caixa4B.saldoBandeja(b3));
                            break;

                        case 4:
                            System.out.println("Saldo = R$" + caixa4B.saldoBandeja(b4));
                            break;

                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                    break;

                case 4:
                    System.out.println("Informa a quantidade de cedulas \n");
                    quantidade = entrada.nextInt();
                    System.out.println(" numero da bandeja \n");
                    bandejaNumero = entrada.nextInt();

                    switch (bandejaNumero) {
                        case 1:
                            caixa4B.depositarBandeja(b1, quantidade);
                            break;

                        case 2:
                            caixa4B.depositarBandeja(b2, quantidade);
                            break;

                        case 3:
                            caixa4B.depositarBandeja(b3, quantidade);
                            break;

                        case 4:
                            caixa4B.depositarBandeja(b4, quantidade);
                            break;

                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                    break;

                case 5:

                    System.out.println("Digite o valor do Saque , Trabalhamos com notas de 100 , 50 , 20 , 5 ");
                    valor = entrada.nextDouble();

                    if (caixa4B.verificaSacarTroco(valor)) {
                        System.out.println("Saque bem sucedido \n");
                        System.out.println("Quantidades de notas de R$ 100 = " + caixa4B.getQuantidades()[0]);
                        System.out.println("Quantidades de notas de R$ 50 = " + caixa4B.getQuantidades()[1]);
                        System.out.println("Quantidades de notas de R$ 20 = " + caixa4B.getQuantidades()[2]);
                        System.out.println("Quantidades de notas de R$ 5 = " + caixa4B.getQuantidades()[3]);
                    } else {

                        System.out.println("Valor Digitado "
                                + "incorreto ou nao temos notas necessarias para efetuar o saque \n");
                    }
                    
                       break;

                case 6:
                    System.out.println("'''''''''''' FINALIZANDO '''''''''''' ");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opcao != 6);
    }

    private static int Menu(Scanner entrada) {
        int opcao;
        System.out.println("// // MENU \\ \\");
        System.out.println("1 - Sacar ");
        System.out.println("2 - Verificar Saldo do Caixa");
        System.out.println("3 - Verificar saldo por Bandeja ");
        System.out.println("4 - Depositar  ");
        System.out.println("5 - Sacar com Troco  ");
        System.out.println("6 - Para Sair ");
        opcao = entrada.nextInt();
        return opcao;
    }

    private static String VerificaCodigo(boolean d, String codigo, Scanner entrada) {
        if (d == false) {

            while (d == false) {

                System.out.println("Codigo errado digite novamente \n");
                codigo = entrada.nextLine();
                d = Pattern.matches("^[aA-zZ]{2}\\d{3}$", codigo);
            }
        }
        return codigo;
    }
}
