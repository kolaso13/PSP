package Hilos.ParkingObjetoSincronized;

public class Coche extends Thread{
    Parking parking;
    String nombre;
    public Coche (String nombre, Parking parking){
        this.nombre=nombre;
        this.parking=parking;
    }

    @Override
    public void run() {
        parking.entrar(nombre);
        parking.esperar();
        parking.salir(nombre);
    }
}
