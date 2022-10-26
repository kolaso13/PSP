package Hilos;

public class Contador {
    int valor=0;
    private Object lock1 = new Object();
    public void Incrementar() throws InterruptedException {
        synchronized(lock1) {
            while(valor==10){
                lock1.wait();
            }
            valor++;
            System.out.println("El hilo incrementador ha actualizado a " + valor);
            lock1.notifyAll();

        }
    }
    public void Decrementar(){
        synchronized(lock1) {
            valor--;
            System.out.println("El hilo decrementador ha actualizado a " + valor);
            lock1.notifyAll();

        }
    }
}
