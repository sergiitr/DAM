import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.println("Introduce un número:");
        numero = sc.nextInt();

        // Variable temporal para guardar el número original
        int temporal = numero;

        // Contamos cuántos dígitos tiene el número en binario
        int contador = 0;
        while (temporal > 0) {
            temporal = temporal / 2;
            contador++;
        }

        // Segundo bucle para reconstruir e imprimir el número binario
        System.out.println("El número en binario es:");
        for (int i = contador - 1; i >= 0; i--) {
            // Calculamos el valor del bit usando potencias de 2
            int potencia = (int) Math.pow(2, i);
            if (numero >= potencia) {
                System.out.print("1");
                numero = numero - potencia;
            } else
                System.out.print("0");
        }
    }
}
