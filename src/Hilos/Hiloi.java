package Hilos;

public class Hiloi implements Runnable{
    int nombre;

    public Hiloi(int nombre){
        this.nombre= nombre;
    }

    @Override
    public void run(){
        System.out.println("Hola soy el hilo "+nombre);
    }
}
