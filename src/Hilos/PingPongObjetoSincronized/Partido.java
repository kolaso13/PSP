package Hilos.PingPongObjetoSincronized;

import java.util.ArrayList;

public class Partido {
    public static void main(String[] args) {
        Pelota pelota = new Pelota();
        ArrayList<Thread> jugadores = new ArrayList<>();
        for (int i=0;i<3;i++){
            jugadores.add(new Ping("PingJugador "+i, pelota));
            jugadores.add(new Pong("PongJugador "+i, pelota));
        }
       jugadores.forEach((t) -> {
           t.start();
       });
        jugadores.forEach((t) -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

    }
}
