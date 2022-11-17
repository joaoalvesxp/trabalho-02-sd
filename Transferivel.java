import java.rmi.*;
public interface Transferivel extends Remote {
    boolean istoPodeSerTransferido(boolean istoPodeSerTransferido) throws RemoteException;
}
