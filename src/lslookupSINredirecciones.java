import java.io.*;
import java.util.Scanner;

public class lslookupSINredirecciones {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/C", "nslookup");
        Process process = pb.start();
        pb.redirectError(ProcessBuilder.Redirect.INHERIT);
        OutputStream outputStream = process.getOutputStream();

        InputStream inputStream = process.getInputStream();
        //Leer
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //Escribir
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        String line;
        while (true) {
            System.out.println("Introduce una IP con buffers");
            Scanner entrada = new Scanner(System.in);
            String comando = entrada.nextLine();

            bufferedWriter.write(comando);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}