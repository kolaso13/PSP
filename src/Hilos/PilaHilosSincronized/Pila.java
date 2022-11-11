package Hilos.PilaHilosSincronized;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pila {
    Deque<String> stack = new ArrayDeque<String>();
    public static int cont=0;
    public int Cantidad(){
        return stack.size();
    }


}
