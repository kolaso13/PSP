package Sockets.Cliente;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class HiloEscritorCliente extends Thread{
    Socket socket;
    public HiloEscritorCliente(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String message = scanner.nextLine();
                if(message.trim().length() > 0){
                    OutputStream outputStream = socket.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
                    writer.write(message);
                    writer.newLine();
                    writer.flush();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
