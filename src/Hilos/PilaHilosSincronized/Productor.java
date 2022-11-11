package Hilos.PilaHilosSincronized;

public class Productor extends Thread{
    String nombre;
    Pila pila;

    public Productor(String nombre, Pila pila){
        this.nombre=nombre;
        this.pila=pila;
    }
    @Override
    public void run() {
        while (true) {
            synchronized (pila) {
                while (pila.Cantidad() >= 5) {
                    try {
                        pila.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                pila.cont++;
                pila.stack.add("Producto " + pila.cont);
                System.out.println(nombre + " He puesto un Producto " + pila.cont);
                pila.notifyAll();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
