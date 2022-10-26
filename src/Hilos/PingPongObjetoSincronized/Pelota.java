package Hilos.PingPongObjetoSincronized;

public class Pelota {

    boolean turno = false;

    public void ping(String nombre) throws InterruptedException {
        synchronized (this){
            while (!turno){
                wait();
            }
            System.out.println("PING "+nombre);
            turno = false;
            notifyAll();
        }
    }

    public void pong(String nombre) throws InterruptedException {
        synchronized (this){
            while (turno){
                wait();
            }
            System.out.printf("PONG %s ", nombre);
            turno = true;
            notifyAll();
        }
    }
}
