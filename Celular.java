import java.rmi.RemoteException;

public class Celular extends Aparelho implements Transferivel {
    public Celular(String nome, Double preço, int quantidadeNoEstoque, boolean transferivel) {
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
