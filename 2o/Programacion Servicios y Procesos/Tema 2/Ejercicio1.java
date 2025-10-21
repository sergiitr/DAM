/**
 * Ejercicio 1
 * @author Sergio Trillo Rodriguez
 */
public class Ejercicio1 extends Thread {

    public static void main(String[] args) {
        Thread actual = Thread.currentThread();
        System.out.println("El id del thread es: " + actual.getId());
        System.out.println("El nombre del hilo es: " + actual.getName());
        System.out.println("El estado actual es: " + actual.getState());
        System.out.println("Mi current Thread es " + actual.currentThread());
        System.out.print("Está alive?? ");
        if (actual.isAlive() == false)
            System.out.println("NO");
        else
            System.out.println("SI");
    }
}
