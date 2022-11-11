import java.io.Serializable;

public class TV extends Aparelho implements Transferivel {
    public TV(String nome, Double preço, int quantidadeNoEstoque, boolean transferivel) {
        super(nome, preço, quantidadeNoEstoque, transferivel);
    }

    @Override
    public boolean tranferivel(boolean podeSerTransferido) {
        if (podeSerTransferido != true){
            return false;
        }
        return true;
    }
}
