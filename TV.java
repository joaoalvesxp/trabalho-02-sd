import java.io.Serializable;
import java.rmi.RemoteException;

public class TV extends Aparelho{
    public TV(String nome, Double preço, int quantidadeNoEstoque, boolean transferivel) {
        super(nome, preço, quantidadeNoEstoque, transferivel);
    }
}
