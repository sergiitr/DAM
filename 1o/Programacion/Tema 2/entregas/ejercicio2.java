/**
 * Ejercicio 2 - Formación de soldados
 * Este programa permite distribuir un número de soldados en tres formaciones posibles: 
 * lineal, cuadrada o triangular. Dependiendo de la formación seleccionada, se muestra 
 * un patrón de asteriscos ('*') que representa la colocación de los soldados, y se indica 
 * cuántos soldados han quedado sobrantes si no se pueden usar todos en la formación.
 * @author Sergio Trillo
 */
import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        /**
         * Constantes para definir las tres formaciones: LINEAL, CUADRADO, TRIANGULO.
         */
        final int LINEAL = 1;
        final int CUADRADO = 2;
        final int TRIANGULO = 3;
        final String ASTERICOS = "*";
        String ESPACIOS = " ";
        
        /**
         * Variables para almacenar el número de soldados, los sobrantes, 
         * los soldados usados y el número de filas.
         */
        int soldados, sobrantes = 0, soldadosUsados = 0, filas = 0;
        int forma;

        /**
         * Se solicita al usuario introducir el número de soldados, asegurándose de que sea mayor o igual a 1.
         */
        do {
            System.out.println("Introduzca el numero de soldados (mayor o igual que 1):");
            soldados = sc.nextInt();
        } while (soldados < 1);

        /**
         * Se solicita al usuario seleccionar la forma de la formación: lineal, cuadrada o triangular.
         */
        do {
            System.out.println("1 - lineal");
            System.out.println("2 - cuadrado");
            System.out.println("3 - triangulo");
            System.out.println("Introduzca forma: ");
            forma = sc.nextInt();
        } while (forma < 1 || forma > 3);

        /**
         * Determinaa la formación seleccionada y ejecutar el código correspondiente.
         */
        switch (forma) {
            /**
             * Caso LINEAL: se imprime una línea continua de asteriscos, 
             * uno por cada soldado.
             */
            case LINEAL:
                for (int i = 0; i < soldados; i++)
                    System.out.print(ASTERICOS);
                break;

            /**
             * Caso CUADRADO: se imprime un cuadrado de asteriscos con tantas filas y columnas como sea posible, 
             * calculadas a partir de la raíz cuadrada del número de soldados.
             * Los sobrantes se muestran al final.
             */
            case CUADRADO:
                filas = (int) Math.sqrt(soldados);
                soldadosUsados = filas * filas;

                // Imprimir el cuadrado
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < filas; j++)
                        System.out.print(ASTERICOS);
                    System.out.println();
                }

                // Calcular y mostrar los soldados sobrantes
                sobrantes = soldados - soldadosUsados;
                System.out.println("Han sobrado " + sobrantes + " figuras");
                break;

            /**
             * Caso TRIANGULO: se imprime un triángulo de asteriscos con tantas filas como sea posible.
             * Cada fila tiene un número creciente de asteriscos. Los sobrantes se muestran al final.
             */
            case TRIANGULO:
                while (soldadosUsados + (filas + 1) <= soldados) {
                    filas++;
                    soldadosUsados += filas;
                }

                // Imprimir el triángulo
                for (int i = 0; i < filas; i++) {
                    // Imprimir espacios
                    for (int j = 0; j < i; j++)
                        System.out.print(ESPACIOS);
                    // Imprimir asteriscos
                    for (int j = (filas - i); j > 0; j--)
                        System.out.print(ASTERICOS + " ");
                    System.out.println();
                }

                // Calcular y mostrar los soldados sobrantes
                sobrantes = soldados - soldadosUsados;
                System.out.println("Han sobrado " + sobrantes + " figuras");
                break;

            /**
             * Opción por defecto en caso de seleccionar una forma no válida.
             */
            default:
                System.out.println("Figura no valida");
                break;
        }
        System.out.println("");
    }
}
