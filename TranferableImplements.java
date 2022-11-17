import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TranferableImplements extends UnicastRemoteObject implements Transferivel{
    protected TranferableImplements() throws RemoteException {
        super();
    }

    @Override
    public boolean istoPodeSerTransferido(boolean istoPodeSerTransferido) throws RemoteException {
        return istoPodeSerTransferido;
    }
}
