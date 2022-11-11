package Hilos.nsLookUpHilos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class hilo extends Thread{
    Process p;

    public hilo( Process p) {
        this.p=p;
    }

    @Override
    public void run() {
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }
            System.out.println("Salgo");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
