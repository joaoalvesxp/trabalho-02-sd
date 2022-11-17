import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) {
        try {
           Transferivel stub = (Transferivel) Naming.lookup("rmi://localhost:1099/Transferivel");
           Boolean teste = true;
           System.out.println(stub.istoPodeSerTransferido(true));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

    }
}