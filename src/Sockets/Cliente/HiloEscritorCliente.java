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
        Scanner scanner = new Scanner(System.in);
        OutputStream outputStream = null;

        try {
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        while (true) {
            try {
                String message = scanner.nextLine();
                if(message.trim().length() > 0){

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