package Hilos.Semaforo;

public class Bloqueo {
    boolean activo = false;
    public void adquirir() {
        synchronized (this){
            while (activo){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            activo = true;
        }
    }

    public void liberar() {
        synchronized (this) {
            activo = false;
            this.notifyAll();
        }
    }
}
