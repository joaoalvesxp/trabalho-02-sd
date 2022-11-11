import java.util.ArrayList;

public class Deposito {
    String nomeDeposito;
    ArrayList<Aparelho> aparelhos;

    public Deposito(String nomeDeposito) {
        this.nomeDeposito = nomeDeposito;
        this.aparelhos = new ArrayList<Aparelho>();
    }

    public ArrayList<Aparelho> getAparelhos() {
        return aparelhos;
    }

    public void setAparelhos(ArrayList<Aparelho> aparelhos) {
        this.aparelhos = aparelhos;
    }

    public void adicionarAparelho(Aparelho aparelho) {
        aparelhos.add(aparelho);
    }

    public void removerAparelho(Aparelho aparelho) {
        aparelhos.remove(aparelho);
    }
    int estoqueAtual;
    public void removerPorUnidade(String nome, int quantidadeRemover) {
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

    public void listarAparelhos () {
        System.out.println("----- PRODUTOS NO DEPOSITO -----");
        aparelhos.forEach((a) -> System.out.println(a));
        System.out.println("--------------------------------");
    }

    public String getNomeDeposito() {
        return nomeDeposito;
    }

    public void setNomeDeposito(String nomeDeposito) {
        this.nomeDeposito = nomeDeposito;
    }

    public void tranferirAparelho(Aparelho aparelho) {

    }
}
