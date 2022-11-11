package Hilos.PilaObjetoSincronized;

import java.util.ArrayList;

public class main {
    public static void main(String[] args){

        Pila pila = new Pila();

        System.out.println("La vida de una empresa de producción y sus clientes");

        ArrayList<Thread> workLife = new ArrayList<>();

        workLife.add(new Thread(new Productor(pila, "Paco")));
        workLife.add(new Thread(new Productor(pila, "Carmen")));
        workLife.add(new Thread(new Productor(pila, "Julito")));
        workLife.add(new Thread(new Consumidor(pila, "Jose Mari")));
        workLife.add(new Thread(new Consumidor(pila, "Maria Jose")));
        workLife.add(new Thread(new Consumidor(pila, "Paquirrín")));

        for (Thread partidazo: workLife) {
            partidazo.start();
        }
    }
}
