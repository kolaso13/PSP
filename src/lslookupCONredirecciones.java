import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class lslookupCONredirecciones {
    public static void main(String[] args) throws IOException, InterruptedException{
        ProcessBuilder pb = new ProcessBuilder("cmd", "/C", "nslookup");
        pb.inheritIO();
        try {
           Process process= pb.start();
           process.waitFor();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
