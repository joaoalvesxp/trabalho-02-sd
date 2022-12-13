import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class DepositoClient {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner nomeDoAparelho = new Scanner(System.in);
        int opcao = -1;

        System.out.println("[CLIENTE] OBJETOS SALVOS APENAS EM RUN TIME!");

        try {
            DepositoInterface stub = (DepositoInterface) Naming.lookup("rmi://localhost:1099/Deposito");
            stub.log("CLIENTE SE CONECTOU!");

            while (opcao != 0) {
                System.out.println("MENU\n1) Adicionar Produto\n2) Remover Produto\n3) Mostrar Produtos\n0) Sair");

                opcao = sc.nextInt();


                if (opcao == 1) {
                    Scanner scannerAdicionar = new Scanner(System.in);

                    int opcaoAdicionar;
                    String nome;
                    Double preco;
                    int quantidade;
                    boolean trasferivel = true;

                    System.out.println("Selecione a categoria:\n1) TVs\n2) Smartphones");
                    opcaoAdicionar = scannerAdicionar.nextInt();

                    TV tv = null;
                    Celular celular = null;

                    scannerAdicionar = new Scanner(System.in);

                    if (opcaoAdicionar == 1) {

                        System.out.println("Nome: ");
                        nome = scannerAdicionar.nextLine();


                        System.out.println("Preço: ");
                        preco = scannerAdicionar.nextDouble();


                        System.out.println("Quantidade: ");
                        quantidade = scannerAdicionar.nextInt();


                        System.out.println("Pode ser transferida?: 1 - Sim  2 - Não");
                        int opcaoDeTransferencia = scannerAdicionar.nextInt();

                        if (opcaoDeTransferencia == 1) {
                            trasferivel = true;
                        } else if (opcaoDeTransferencia == 2){
                            trasferivel = false;
                        }

                        else {
                            System.out.println("Opção Inválida! Transferivel selecionado com Default: true");
                        }

                        tv = new TV(nome, preco, quantidade, trasferivel);

                        stub.adicionarAparelho(tv);
                        stub.log("Tv adicionada com sucesso!");
                        System.out.println("Tv adicionada com sucesso!");
                    }

                    else if (opcaoAdicionar == 2) {

                        System.out.println("Adicionando um Celular\nNome: ");
                        nome = scannerAdicionar.nextLine();

                        System.out.println("Preço: ");
                        preco = scannerAdicionar.nextDouble();

                        System.out.println("Quantidade: ");
                        quantidade = scannerAdicionar.nextInt();

                        System.out.println("Pode ser transferida?: 1 - Sim  2 - Não");
                        int opcaoDeTransferencia = scannerAdicionar.nextInt();

                        if (opcaoDeTransferencia == 1) {
                            trasferivel = true;
                        } else if (opcaoDeTransferencia == 2) {
                            trasferivel = false;
                        }
                        else {
                            System.out.println("Opção Inválida! Transferivel selecionado com Default: true");
                        }

                        celular = new Celular(nome, preco, quantidade, trasferivel);
                        stub.adicionarAparelho(celular);
                        stub.log("Celular adicionado com sucesso!");
                        System.out.println("[CLIENTE] Celular adicionado com sucesso!");

                    } else {
                        System.out.println("Categoria não encontada! Selecione uma categoria existente");
                    }
                } else if (opcao == 2) {
                    System.out.println("DIGITE O NOME DO APARELHO: ");
                    String nome = nomeDoAparelho.nextLine();
                    stub.removerAparelho(nome);
                } else if (opcao == 3) {
                    stub.log("LISTANDO PRODUTOS NO ESTOQUE!");
                    stub.listarAparelhos();

                    System.out.println("LISTANDO PRODUTOS NO ESTOQUE!");
                } else if (opcao == 0) {
                    stub.log("CLIENTE DESCONECTADO!");

                    System.out.println("CLIENTE DESCONECTADO!");
                    break;
                }

            }


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}