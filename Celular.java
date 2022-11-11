public class Celular extends Aparelho implements Transferivel {
    public Celular(String nome, Double preço, int quantidadeNoEstoque, boolean transferivel) {
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
