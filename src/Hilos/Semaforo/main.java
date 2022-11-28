package Hilos.Semaforo;

import Hilos.Semaforo.Coche;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Parking parking = new Parking();
        ArrayList<Thread> coches = new ArrayList<>();
        for (int i=0;i<100;i++){
            coches.add(new Coche("Coche "+i, parking));
        }
        coches.forEach((t) -> {
            t.start();
        });
        coches.forEach((t) -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
