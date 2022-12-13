import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class DepositoImplements extends UnicastRemoteObject implements DepositoInterface {
        String nomeDeposito;
        ArrayList<Aparelho> aparelhos;
        int estoqueAtual;

        protected DepositoImplements(String nomeDeposito) throws RemoteException {
            super();
            this.nomeDeposito = nomeDeposito;
            this.aparelhos = new ArrayList<Aparelho>();
            this.estoqueAtual = 0;
        }

        public ArrayList<Aparelho> getAparelhos() throws RemoteException {
            return aparelhos;
        }

        public void setAparelhos(ArrayList<Aparelho> aparelhos) throws RemoteException {
            this.aparelhos = aparelhos;
        }

        public void adicionarAparelho(Aparelho aparelho) throws RemoteException {
            aparelhos.add(aparelho);
        }

        public void removerAparelho(String nomeAparelho) throws RemoteException {

            if (aparelhos.size() == 0) {
                log("ESTOQUE VAZIO, ADICIONE APARELHOS PARA ESSA AÇÃO!");
            } else {

            for (int i = 0; i < aparelhos.size(); i++) {
                if (aparelhos.get(i).getNome().equals(nomeAparelho)) {
                    aparelhos.remove(i);
                    System.out.println("APARELHO REMOVIDO COM SUCESSO! ESTOQUE ATUAL");
                    listarAparelhos();
                } else {
                    System.out.println("APARELHO NÃO ENCONTRADO!");
                }
            }
            }
        }
        public void removerPorUnidade(String nome, int quantidadeRemover) throws RemoteException {
            for (int i = 0; i < aparelhos.size(); i++) {

                if(aparelhos.get(i).getNome().equals(nome)) {
                    estoqueAtual = aparelhos.get(i).getQuantidadeNoEstoque();
                    if (quantidadeRemover == 0 || quantidadeRemover > estoqueAtual) {
                        System.out.println("Não foi possível remover, escolha quantidade entre 1 e " + estoqueAtual);
                    }
                    else {
                        estoqueAtual = estoqueAtual - quantidadeRemover;
                        aparelhos.get(i).setQuantidadeNoEstoque(estoqueAtual);
                        aparelhos.get(i).setPrecoTotal((estoqueAtual * aparelhos.get(i).getPreço()));
                        System.out.println(aparelhos.get(i));
                    }
                }
                else {
                    System.out.println("Não Achei o produto: " + nome);
                }
            }
        }

        public void listarAparelhos () throws RemoteException {
            System.out.println("----- PRODUTOS NO DEPOSITO -----");
            aparelhos.forEach((a) -> System.out.println(a));
            System.out.println("--------------------------------");
        }
        public void log(String mensagem) throws RemoteException {
            System.out.println("[ LOG ] " + mensagem);
        }
}
