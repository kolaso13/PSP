package Hilos.PingPongHilosSincronized;

import static java.lang.Thread.sleep;

public class Pong extends Thread {
    Pelota pelota;
    int num;
    String nombre;

    public Pong(String nombre, Pelota pelota) {
        this.nombre = nombre;
        this.pelota = pelota;
    }

    public void run() {
        while (true) {
            synchronized (pelota) {
                while (pelota.turno) {
                    try {
                        pelota.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.printf("PONG %s ", nombre);
                pelota.turno = true;
                pelota.notifyAll();
            }
        }
    }
}