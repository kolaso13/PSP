package Hilos.PilaObjetoSincronized;

import java.util.Stack;

import static java.lang.Thread.sleep;

public class Pila {
    private Stack pilarda = new Stack();
    private int maxProdcutos = 5;
    private int numProd = 0;
    private Object lock = new Object();

    public Pila(){
    }

    public void anyadir(String productor) throws InterruptedException {

        synchronized (lock){
            while (pilarda.size() >= maxProdcutos){
                lock.wait();
            }

            numProd++;

            String producto = "producto " + numProd;

            pilarda.add(producto);
            System.out.println("El productor " + productor + " ha añadido el producto: " + producto);

            Thread.sleep(1000);

            lock.notifyAll();
        }

    }

    public void recoger(String consumidor) throws InterruptedException {

        synchronized (lock){
            while (pilarda.size() <= 0){
                lock.wait();
            }

            System.out.println("El consumidor: " + consumidor + " ha recogido el producto " + pilarda.pop());

            Thread.sleep(1000);
            lock.notifyAll();}

    }

}
