package Hilos;

public class Tarea {
    int tiempo;
    public Tarea(int tiempo){
        this.tiempo=tiempo * 1000;
    }
    public void Ejecutar()  {
        try {
            System.out.println("ejecutando tarea de "+tiempo+" ml");
            Thread.sleep(tiempo);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
