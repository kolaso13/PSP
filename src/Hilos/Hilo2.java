package Hilos;

public class Hilo2 extends Thread{
    @Override
    public void run() {
        // compute primes larger than minPrime
        while (true){
            System.out.println("Soy Hilo2");
        }
    }
}
