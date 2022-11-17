import java.io.Serializable;
import java.rmi.RemoteException;

public class TV extends Aparelho implements Transferivel {
    public TV(String nome, Double preço, int quantidadeNoEstoque, boolean transferivel) {
        super(nome, preço, quantidadeNoEstoque, transferivel);
    }

    @Override
    public boolean istoPodeSerTransferido(boolean istoPodeSerTransferido) throws RemoteException {
        if (istoPodeSerTransferido) {
            return true;
        } else {
            return false;
        }
    }
}
