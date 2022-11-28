package Sockets.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    static ServerSocket server;
    static List<Socket> listaHiloClients = new ArrayList<>();
    static int contador=0;
    public static void main(String[] args) throws IOException {
         server = new ServerSocket(5555);
        while (true) {
            Socket cliente = server.accept();
            Thread thread = new Thread(new HiloDelServer(cliente, contador));
            listaHiloClients.add(cliente);
            contador++;
            thread.start();
        }
    }
}

