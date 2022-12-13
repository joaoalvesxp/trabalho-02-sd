import java.rmi.RemoteException;

public class Celular extends Aparelho {
    public Celular(String nome, Double preço, int quantidadeNoEstoque, boolean transferivel) {
        super(nome, preço, quantidadeNoEstoque, transferivel);
    }
}
