package Hilos.nsLookUpHilos;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        boolean termina = false;
        Scanner sc = new Scanner(System.in);
        ProcessBuilder pb = new ProcessBuilder("cmd", "/C", "nslookup");
        pb.redirectError(ProcessBuilder.Redirect.INHERIT);
        Process p = pb.start();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
        hilo hilo = new hilo(p);
        hilo.start();

        while (!termina){
            System.out.println("IP?");
            String texto = sc.nextLine();

            bufferedWriter.write(texto);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            if(texto.equalsIgnoreCase("exit")){
                bufferedWriter.close();
                p.destroy();
                termina = true;
            }

        }
    }
}
