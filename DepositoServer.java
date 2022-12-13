import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DepositoServer {
    public static void main(String[] args) {

        try {

            Registry registry = LocateRegistry.createRegistry(1099);

            DepositoInterface depositoPrincipal;
            depositoPrincipal = new DepositoImplements("DEPÓSITO PRINCIPAL");

            Naming.rebind("rmi://localhost:1099/Deposito", depositoPrincipal);

            System.out.println("[SERVER] Servidor RMI iniciado.");
            System.out.println("[METODOS INVOCADOS PELO CLIENTE]");

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}