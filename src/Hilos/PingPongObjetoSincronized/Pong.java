package Hilos.PingPongObjetoSincronized;

public class Pong extends Thread {
    Pelota pelota;
    int num;
    String nombre;

    public Pong(String nombre, Pelota pelota) {
        this.nombre = nombre;
        this.pelota = pelota;
    }

    @Override
    public void run() {
        while (true) {
            try {
                pelota.pong(nombre);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}