import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente implements  Serializable {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("MENU\n1) Adicionar Produto\n2) Remover Produto\n3) Mostrar Produtos\n4) Transferir Produto\n0) Sair");
        int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    adicionar();
                    break;
                case 2:
                    remover();
                    break;
                case 3:
                    mostarProdutosNoDeposito();
                    break;
                case 4:
                    break;
                case 0:
                    break;
            }

            sc.close();
    }


    private static void adicionar() {

        Scanner scannerAdicionar = new Scanner(System.in);

        int opcaoAdicionar;
        String nome;
        Double preco;
        int quantidade;
        boolean trasferivel = true;

        System.out.println("Selecione a categoria:\n1) TVs\n2) Smartphones");
        opcaoAdicionar = scannerAdicionar.nextInt();

        ArrayList<TV> tvs = null;
        ArrayList<Celular> celulares = null;
        ArrayList<Object> objetos = new ArrayList<>();

        scannerAdicionar = new Scanner(System.in);

        if (opcaoAdicionar == 1) {
            tvs = new ArrayList<>();

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

                tvs.add(new TV(nome, preco, quantidade, trasferivel));

                System.out.println("Tv adicionada com sucesso!");

            }

           else if (opcaoAdicionar == 2) {
                celulares = new ArrayList<>();

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

                celulares.add(new Celular(nome, preco, quantidade, trasferivel));

                System.out.println("Celular adicionado com sucesso!");

        } else {
            System.out.println("Categoria não encontada! Selecione uma categoria existente");
        }

        if (tvs != null) {
            for (int i = 0; i < (tvs.size()); i++) {
                objetos.add(tvs.get(i));
            }
        }

        if (celulares != null) {
            for (int i = 0; i < (celulares.size()); i++) {
                objetos.add(celulares.get(i));
            }
        }

        empacotar(objetos);
        scannerAdicionar.close();
    }

    private static void transferir() {

    }

    private static void remover() {
        Scanner scannerRemover = new Scanner(System.in);

        System.out.printf("Remover Produto\nDigite o nome do produto: ");
        String nomeProdutoRemover = scannerRemover.nextLine();
        ArrayList<Object> objetosDoDepositoOficial = Desempacotamento.lerArquivoBinario("deposito_principal.dat");
        ArrayList<Aparelho> objetosDoDepositoOficialCast = (ArrayList<Aparelho>) (ArrayList<?>) objetosDoDepositoOficial;

        for (int i = 0; i < objetosDoDepositoOficial.size(); i++) {
            if (objetosDoDepositoOficialCast.get(i).getNome().equals(nomeProdutoRemover)) {
                objetosDoDepositoOficialCast.remove(i);
            }
        }
        ArrayList<Object> objetosDoDepositoOficialAtualizado = (ArrayList<Object>) (ArrayList<?>) objetosDoDepositoOficialCast;
        Empacotamento.gravarArquivoBinario(objetosDoDepositoOficialAtualizado,"deposito_principal.dat");
        empacotar(objetosDoDepositoOficialAtualizado);
    }

    private static void mostarProdutosNoDeposito() {
        ArrayList<Object> objetosDoDepositoOficial = Desempacotamento.lerArquivoBinario("deposito_principal.dat");
        objetosDoDepositoOficial.forEach((n) -> System.out.println(n));
    }

    private static void empacotar(ArrayList<Object> aparelhos) {
        Socket socket = null; // Socket Cliente

        try {
            int serverPort = 7896; // Porta do Servidor
            socket = new Socket("localhost", serverPort);

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
            outStream.writeObject(aparelhos);

        } catch (UnknownHostException e) {
            System.out.println("Socket:" + e.getMessage());
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("readline:" + e.getMessage());
        } finally {
            if (socket != null)
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("close:" + e.getMessage());
                }
        }

    }
}


