package Hilos.PingPongHilosSincronized;

public class Ping extends Thread{
    Pelota pelota;
    int num;
    String nombre;

    public Ping(String nombre, Pelota pelota){
        this.nombre = nombre;
        this.pelota = pelota;
    }
    public void run(){
       while (true){
           synchronized (pelota){
               while (!pelota.turno){
                   try {
                       pelota.wait();
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
               }
               System.out.println("PING "+nombre);
               pelota.turno = false;
               pelota.notifyAll();
           }
       }
    }
}

