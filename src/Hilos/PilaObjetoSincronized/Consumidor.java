package Hilos.PilaObjetoSincronized;

import Hilos.PilaObjetoSincronized.Pila;

import static java.lang.Thread.sleep;

public class Consumidor implements Runnable{
    private Pila pililla;
    private String nombre;

    public Consumidor(Pila pililla, String nombre){
        this.pililla = pililla;
        this.nombre = nombre;
    }

    @Override
    public void run(){

        while (true){
            try {
                pililla.recoger(nombre);
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
