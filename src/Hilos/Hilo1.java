package Hilos;

public class Hilo1  extends Thread{
    // compute primes larger than minPrime
    @Override
    public void run() {
        // compute primes larger than minPrime
        while (true){
            System.out.println("Soy Hilo1");
        }
    }
}
