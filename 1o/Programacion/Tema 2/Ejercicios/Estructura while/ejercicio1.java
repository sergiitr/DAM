
import java.util.Scanner;

public class ejercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero1 = 1;
        int cuadrado;
        System.out.println("Introduzca un numeros ");
        numero1 = sc.nextInt();
        while (numero1 != 0) {
            if (numero1 % 2 == 0)
                System.out.println("Es par"); 
            else
                System.out.println("Es impar");
            

            if (numero1 > 0)
                System.out.println("Es positivo"); 
        	else
                System.out.println("Es negativo");
            
            cuadrado = numero1 * numero1;
            System.out.println("El cuadrado del numero " + numero1 + " es " + cuadrado);
            System.out.println();
            System.out.println("Introduzca un numeros ");
            numero1 = sc.nextInt();
        }
    }
}
