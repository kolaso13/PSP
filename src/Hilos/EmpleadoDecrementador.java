package Hilos;

public class EmpleadoDecrementador extends Thread{
    String nombre;
    Contador contador;
    int num;

    public EmpleadoDecrementador(String nombre, Contador contador, int num){
        this.nombre=nombre;
        this.contador=contador;
        this.num=num;
    }

    public void run(){
        for (int i=0; i<num;i++) {
            contador.Decrementar();
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            System.out.println("El hilo " + nombre + " ha actualizado a " + contador.valor);
        }
    }
}
