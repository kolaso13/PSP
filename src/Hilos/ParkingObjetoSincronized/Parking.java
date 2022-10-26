package Hilos.ParkingObjetoSincronized;

import static java.lang.Thread.sleep;

public class Parking {
    int cont=0;
    public void entrar(String nombre){
        synchronized (this){
            while (cont >= 5){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Entra el coche "+nombre);
            cont++;
        }
    }
    public void esperar(){
        try {
            sleep((long) (Math.random()*10+5)*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void salir(String nombre){
        synchronized (this) {
            System.out.println("Sale el coche " + nombre);
            cont--;
            notifyAll();
        }
    }
}
