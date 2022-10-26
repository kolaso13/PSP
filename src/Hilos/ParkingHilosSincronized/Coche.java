package Hilos.ParkingHilosSincronized;

public class Coche extends Thread{
    Parking parking;
    String nombre;
    public Coche (String nombre, Parking parking){
        this.nombre=nombre;
        this.parking=parking;
    }

    @Override
    public void run() {
            synchronized (parking){
                while (parking.cont >= 5){
                    try {
                        parking.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                entrar();
            }
            esperar();
            synchronized (parking){
                salir();
            }
    }
    public void entrar(){
        System.out.println("Entra el coche "+nombre);
        parking.cont++;
    }
    public void salir(){
        System.out.println("Sale el coche "+nombre);
        parking.cont--;
        parking.notifyAll();
    }
    public void esperar(){
        try {
            sleep((long) (Math.random()*10+5)*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
