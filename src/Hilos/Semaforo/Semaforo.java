package Hilos.Semaforo;

import static java.lang.Thread.sleep;

public class Semaforo {
    private int max;
    int cont=0;

    public Semaforo(int max) {
        this.max = max;
    }

    public void adquirir(){
        synchronized (this){
            while (cont >= max){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            cont++;
        }
    }

    public void liberar(){
        synchronized (this) {
            cont--;
            this.notifyAll();
        }
    }
}
