package Hilos;

public class Hilo extends Thread{
    String text;

    public Hilo(String text){
        this.text=text;
    }
    @Override
    public void run() {
        System.out.println(text);
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }System.out.println("El hilo "+text+" ha terminado");
    }


}
