package Sockets.Cliente;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5555);

        HiloEscritorCliente hiloEscritorCliente = new HiloEscritorCliente(socket);
        hiloEscritorCliente.start();

        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }
    }
}


