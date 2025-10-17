/**
 * Ejercicio 1 Entregas - Estilos de natación
 * Este programa permite introducir una cantidad de largos realizados en una piscina (entre 0 y 50),
 * y luego asigna un estilo de natación a cada largo de acuerdo a las siguientes reglas:
 * - Los largos en posiciones impares comienzan con Crol.
 * - Los largos en posiciones pares son de Espalda.
 * - Cada tercer largo (empezando desde el tercer largo) es de Braza.
 * @author Sergio Trillo
 */
import java.util.Scanner;

public class ejercicio1 {

    public static void main(String[] args) {
        /**
         * Scanner para leer la entrada del usuario.
         */
        Scanner sc = new Scanner(System.in);
        int cantidadLargos;

        /**
         * Bucle do-while para asegurarse de que el número de largos introducido está entre 0 y 50.
         * En caso de introducir un número fuera de este rango, se vuelve a pedir.
         */
        do {
            System.out.println("Introduzca el numero de largos realizados (entre 0 y 50):");
            cantidadLargos= sc.nextInt();
        } while (cantidadLargos < 0 || cantidadLargos > 50);

        /**
         * Se inicia la impresión de la secuencia de estilos de natación.
         */
        System.out.print("{");

        /**
         * Bucle for que recorre cada largo desde 1 hasta la cantidad de largos introducida por el usuario.
         * Se imprime un estilo de natación para cada largo en función de su número.
         */
        for (int i = 1; i <= cantidadLargos; i++) {
            /**
             * Si el largo está en una posición múltiplo de 4 más 1 (1, 5, 9, etc.), el estilo es Crol.
             */
            if (i % 4 == 1)
                System.out.print(" Crol ");

            /**
             * Si el largo está en una posición par (2, 4, 6, etc.), el estilo es Espalda.
             */
            if (i % 2 == 0)
                System.out.print(" Espalda ");

            /**
             * Si el largo está en una posición múltiplo de 4 más 3 (3, 7, 11, etc.), el estilo es Braza.
             */
            if (i % 4 == 3)
                System.out.print(" Braza ");
        }
        System.out.print("}");
        System.out.println();
    }
}
