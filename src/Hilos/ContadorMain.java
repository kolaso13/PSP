package Hilos;

public class ContadorMain {

    public static void main(String[] args) throws InterruptedException {
        Contador cont = new Contador();
        int num= 20;
//        for(int i=0;i<2;i++){
//            hilo = new Thread(new EmpleadoIncrementador("CarlIncrementador"+i, cont));
//            hilo.start();
//        }

        Thread hilo = new Thread(new EmpleadoIncrementador("CarlIncrementador", cont, num));
        Thread hilo2 = new EmpleadoDecrementador("CarlDecrementador", cont, num);

        Thread hilo3 = new Thread(new EmpleadoIncrementador("CarlIncrementador2", cont, num));
        Thread hilo4 = new EmpleadoDecrementador("CarlDecrementador3", cont, num);

        hilo.start();
        hilo2.start();

        hilo3.start();
        hilo4.start();

        hilo.join();
        hilo2.join();
        System.out.println("Valor final: "+cont.valor);
    }
}
