package servidor;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        final int PORT = 5555;
        ServerSocket servidorSocket;
        Socket socketCliente;

        try {
            servidorSocket = new ServerSocket(PORT);

            while (true) {
                System.out.println("Aguardando conexão...");
                socketCliente = servidorSocket.accept();

                Cavalo cavalo = new Cavalo(socketCliente);
                cavalo.start();
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
