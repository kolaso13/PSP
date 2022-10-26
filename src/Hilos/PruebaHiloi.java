package Hilos;

public class PruebaHiloi {
    public static void main(String[] args) {
        Thread hilo = new Thread(new Hiloi(1));
        hilo.start();
    }
}
