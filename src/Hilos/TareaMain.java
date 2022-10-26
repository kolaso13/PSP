package Hilos;

import java.util.ArrayList;

public class TareaMain {
    public static void main(String[] args) throws InterruptedException{
        ArrayList<Tarea> listaTareas = new ArrayList<>();


        for(int i=0; i<3;i++){
            listaTareas.add(new Tarea(i+1*5));
        }

        for(int i=0;i<listaTareas.size();i++){
            Thread hilo = new Thread(new Empleado("Carl "+i, listaTareas.get(i)));
            hilo.start();
        }
    }
}
