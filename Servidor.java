import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Servidor {
    public static void main(String args[]) {
        try {
            System.out.println("Servidor iniciado");
            int serverPort = 7896; // the server port
            ServerSocket listenSocket = new ServerSocket(serverPort);
            while (true) {
                Socket clientSocket = listenSocket.accept();
                System.out.println(clientSocket.getInetAddress());
                System.out.println("conexão estabelecida");
                Connection c = new Connection(clientSocket);
            }
        } catch (IOException e) {System.out.println("Listen socket:" + e.getMessage());}
    }
}

class Connection extends Thread {
    DataInputStream in;
    DataOutputStream out;
    Socket clientSocket;

    public Connection(Socket aClientSocket) {
        Deposito depositoPrincipal = new Deposito("Deposito Principal");
        Deposito depositoSecundario = new Deposito("Deposito Secundario");
        ArrayList<Object> objetos = new ArrayList<>();
        try {
            clientSocket = aClientSocket;
            in = new DataInputStream(clientSocket.getInputStream());
            /*out = new DataOutputStream(clientSocket.getOutputStream());*/
            System.out.println(in.readUTF());

            ObjectInputStream inStream = new ObjectInputStream (clientSocket.getInputStream());
            objetos = new ArrayList<> ((ArrayList<Object>) inStream.readObject());

            for (int i = 0; i < (objetos.size()); i++) {
                depositoPrincipal.adicionarAparelho((Aparelho) objetos.get(i));
            }

            depositoPrincipal.listarAparelhos();

            Empacotamento.gravarArquivoBinario(objetos,"deposito_principal.dat");


            inStream.close();
            this.start();
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        } catch (Exception e) {
            e.getStackTrace();
        }
    }


}