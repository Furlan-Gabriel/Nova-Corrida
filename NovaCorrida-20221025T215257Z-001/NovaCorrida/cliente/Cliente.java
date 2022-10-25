package cliente;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import util.MsgReq;
import util.MsgResp;
import util.Status;

public class Cliente {
    public static void main(String[] args) {
        final String IP = "127.0.0.1";
        final int PORT = 5555;
        Socket socket;
        double aposta;
        String cavalo;
        ObjectOutputStream out;
        ObjectInputStream in;
        Scanner entrada = new Scanner(System.in);

        try {
            socket = new Socket(IP, PORT);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            System.out.println("Informe o valor da aposta: ");
            aposta = entrada.nextDouble();
            System.out.println("Informe o nome do cavalo: ");
            cavalo = entrada.nextLine().toString();

            MsgReq msgReq = new MsgReq(aposta, cavalo);

            out.writeObject(msgReq);

            MsgResp msgResp = (MsgResp) in.readObject();

            if (msgResp.getStatus() == Status.SUCESSO) {
                System.out.println("Resposta: " + msgResp.getValue());
            } else {
                System.out.println("Escolha inválida");
            }

            socket.close();
            entrada.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
