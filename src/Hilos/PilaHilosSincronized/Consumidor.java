package Hilos.PilaHilosSincronized;

public class Consumidor extends Thread{
    String nombre;
    Pila pila;

    public Consumidor(String nombre, Pila pila){
        this.nombre = nombre;
        this.pila = pila;
    }
    @Override
    public void run() {
        while (true){
            synchronized (pila){
                while (pila.Cantidad() <= 0 ){
                    try {
                        pila.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                String top = pila.stack.pop();
                System.out.println(nombre+" He cogido un "+top);
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
