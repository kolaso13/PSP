package Hilos.PilaHilosSincronized;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Pila pila= new Pila();
        ArrayList<Thread> Productor = new ArrayList<>();
        ArrayList<Thread> Consumidor = new ArrayList<>();

        for (int i=0;i<3;i++){
            Productor.add(new Productor("Productor "+i, pila));
            Consumidor.add(new Consumidor("Consumidor "+i, pila));
        }
        Productor.forEach((t) -> {
            t.start();
        });
        Consumidor.forEach((t) -> {
            t.start();
        });
    }
}
