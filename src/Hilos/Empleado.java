package Hilos;

public class Empleado implements Runnable{
    String nombre;
    Tarea tarea;

    public Empleado(String nombre, Tarea tarea){
        this.nombre=nombre;
        this.tarea= tarea;
    }

    @Override
    public void run(){
        tarea.Ejecutar();
        System.out.println("El empleado "+ nombre+ ", ha acabado la tarea "+tarea.tiempo);
    }
}
