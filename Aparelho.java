import java.io.Serializable;

public class Aparelho implements Serializable {
    private String nome;
    private Double preço;
    private int quantidadeNoEstoque;
    private Double precoTotal;

    private boolean transferivel = false;

    public Aparelho(String nome, Double preço, int quantidadeNoEstoque, boolean transferivel) {
        this.nome = nome;
        this.preço = preço;
        this.quantidadeNoEstoque = quantidadeNoEstoque;
        this.precoTotal = getPrecoTotal();
        this.transferivel = transferivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreço() {
        return preço;
    }

    public Double getPrecoTotal() {
        precoTotal = getPreço() * getQuantidadeNoEstoque();
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {

        this.precoTotal = precoTotal;
    }

    public void setPreço(Double preço) {
        this.preço = preço;
    }

    public int getQuantidadeNoEstoque() {
        return quantidadeNoEstoque;
    }

    public void setQuantidadeNoEstoque(int quantidadeNoEstoque) {
        this.quantidadeNoEstoque = quantidadeNoEstoque;
    }

    public Aparelho(boolean transferivel) {
        this.transferivel = transferivel;
    }

    public boolean isTransferivel() {
        return transferivel;
    }

    public void setTransferivel(boolean transferivel) {
        this.transferivel = transferivel;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                ", Preço: R$ " + preço +
                ", Quantidade: " + quantidadeNoEstoque +
                ", Preço Total: R$ " + precoTotal;
    }
}

