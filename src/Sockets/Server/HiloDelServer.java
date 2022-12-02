package Sockets.Server;

import java.io.*;
import java.net.Socket;

public class HiloDelServer extends Thread{
    Socket socket;
    int contador;

    public HiloDelServer(Socket socket, int contador){
        this.socket = socket;
        this.contador = contador;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String finalLine = "Cliente Num " +contador +": "+line;
                System.out.println(finalLine);

                Server.listaHiloClients.forEach(HiloCliente -> {

                    try {
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(HiloCliente.getOutputStream()));
                        bufferedWriter.write(finalLine);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}