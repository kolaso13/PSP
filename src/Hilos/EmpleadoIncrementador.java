package Hilos;

public class EmpleadoIncrementador implements Runnable{
    String nombre;
    Contador contador;
    int num;
    public EmpleadoIncrementador(String nombre, Contador contador, int num){
        this.nombre=nombre;
        this.contador=contador;
        this.num=num;
    }
    @Override
    public void run(){
        for (int i=0; i<num;i++) {

            try {
                contador.Incrementar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            System.out.println("El hilo " + nombre + " ha actualizado a " + contador.valor);
        }
    }
}
