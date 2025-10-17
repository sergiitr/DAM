
import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Electrodomestico e1 = new Electrodomestico("marca", 1000);
        Lavadora l1 = new Lavadora(150.0, "marca 2", 1200);
        Lavadora l2 = new Lavadora("marca", 1300, 200, true);
        
        int horas;

        System.out.println("Electrodomestico: "+e1.toString());
        System.out.println("Lavadora: "+l1.toString());
        System.out.println("Lavadora2: "+l2.toString());

        System.out.print("Introduzca el numero de horas: ");
        horas = sc.nextInt();
        System.out.println("El consumo en la primera lavadora es: "+l1.getConsumo(horas));
        System.out.println("El consumo en la segunda lavadora es: "+l2.getConsumo(horas));
    }
}