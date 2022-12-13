import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DepositoInterface extends Remote {
    public void adicionarAparelho(Aparelho aparelho) throws RemoteException;
    public void removerAparelho(String nomeAparelho) throws RemoteException;
    public void removerPorUnidade(String nome, int quantidadeRemover) throws RemoteException;
    public void listarAparelhos () throws RemoteException;

    public void log(String mensagem) throws RemoteException;
}
