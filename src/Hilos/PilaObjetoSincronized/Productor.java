package Hilos.PilaObjetoSincronized;

import Hilos.PilaObjetoSincronized.Pila;

public class Productor implements Runnable{
    private Pila pililla;
    private String nombre;

    public Productor(Pila pililla, String nombre){
        this.pililla = pililla;
        this.nombre = nombre;
    }

    @Override
    public void run(){


        while (true){
            try {
                pililla.anyadir(nombre);
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
