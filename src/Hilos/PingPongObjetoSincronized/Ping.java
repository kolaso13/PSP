package Hilos.PingPongObjetoSincronized;

public class Ping extends Thread{
    Pelota pelota;
    int num;
    String nombre;

    public Ping(String nombre, Pelota pelota){
        this.nombre = nombre;
        this.pelota = pelota;
    }

    @Override
    public void run(){
       while (true){
           try {
               pelota.ping(nombre);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
    }
}

