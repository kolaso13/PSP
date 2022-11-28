package Hilos.Semaforo;

import java.util.concurrent.locks.Lock;

import static java.lang.Thread.sleep;

public class Parking {
    private int Num_Plazas = 5;
    private int plazaslibres = Num_Plazas;
    Semaforo semaforo = new Semaforo(5);
    Bloqueo bloqueo = new Bloqueo();
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public void entrar(String Nombrecoche){
        semaforo.adquirir();
        bloqueo.adquirir();
        plazaslibres--;
        System.out.println(ANSI_GREEN+Nombrecoche+" ha entrado, plazas libre "+plazaslibres);
        bloqueo.liberar();
    }

    public void salir(String Nombrecoche){
        bloqueo.adquirir();
        plazaslibres++;
        System.out.println(ANSI_RED+ Nombrecoche+ " ha salido, plazas libre "+plazaslibres);
        bloqueo.liberar();
        semaforo.liberar();
    }


}
