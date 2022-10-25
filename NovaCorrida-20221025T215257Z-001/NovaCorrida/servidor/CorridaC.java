package servidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

public class CorridaC {

    public static void main(String[] args) throws InterruptedException {
        Thread[] Cavalo = new Thread[5];
        Cavalo[0] = new Thread(new Cavalo("Cavalo 1"));
        Cavalo[1] = new Thread(new Cavalo("Cavalo 2"));
        Cavalo[2] = new Thread(new Cavalo("Cavalo 3"));
        Cavalo[3] = new Thread(new Cavalo("Cavalo 4"));
        Cavalo[4] = new Thread(new Cavalo("Cavalo 5"));
        System.out.println("-*-*-*-*-*-*-*-*-*- Pista de 250 metros -*-*-*-*-*-*-*-*-*-");
        Thread.sleep(3 * 1000);
        System.out.println("3...");
        Thread.sleep(1 * 1000);
        System.out.println("2...");
        Thread.sleep(1 * 1000);
        System.out.println("1...");
        Thread.sleep(1 * 1000);
        System.out.println("Corrida iniciada!");
        for (int i = 0; i < Cavalo.length; ++i) {
            Cavalo[i].start();
        }
        for (int i = 0; i < Cavalo.length; ++i) {
            Cavalo[i].join();
        }
        System.out.println("Corrida terminada !!!");
    }
}

class Cavalo extends Thread {
    private String nome;
    private Socket socketCliente;

    public Cavalo(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }

    public Cavalo(String str) {
        nome = str;
    }

    static Random r = new Random();

    @Override
    public void run() {
        ObjectOutputStream out;
        ObjectInputStream in;

        long t = System.currentTimeMillis();
        try {
            Thread.sleep(r.nextInt(100)); // bound:100000
        } catch (InterruptedException ex) {
        }
        t = System.currentTimeMillis() - t;
        long minutos = (t / 1000) / 60;
        long segundos = (t / 1000) % 60;
        System.out.println(nome + " chegou em " + minutos + " minutos e " + segundos + " segundos");
    }
}
