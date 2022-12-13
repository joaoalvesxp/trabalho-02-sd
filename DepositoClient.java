import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class DepositoClient {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = sc.nextInt();
        
        while (opcao != 0) {
            System.out.println("MENU");

            opcao = sc.nextInt();
            if(opcao == 1) {
                System.out.println("OK");
            }
        }

        try {
            DepositoInterface stub = (DepositoInterface) Naming.lookup("rmi://localhost:1099/Deposito");




        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}