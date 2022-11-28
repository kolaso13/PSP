package Hilos.Semaforo;

import Hilos.Semaforo.Parking;

public class Coche extends Thread{
    Parking parking;
    String nombre;
    public Coche(String nombre, Parking parking){
        this.nombre=nombre;
        this.parking=parking;
    }

    @Override
    public void run() {
        parking.entrar(nombre);
            try {
                sleep((long) (Math.random()*10+5)*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        parking.salir(nombre);
    }
}
