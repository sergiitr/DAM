import java.util.Scanner;

public class ejemplo1 {
    /**
     * Funcion para crear nuestras matrices con numeros random
     * @param tamanio
     * @return matriz
     */
    public static int[][] crearMatriz(int tamanio) {
        int[][] matriz = new int[tamanio][tamanio];
        for (int i=0;i<tamanio; i++) {
            for (int j=0;j<tamanio;j++)
                matriz[i][j] = (int)(Math.random()*10);
        }
        return matriz;
    }

    /**
     * Funcion para sumar 2 matrices
     * @param matriz1
     * @param matriz2
     * @param tamanio
     * @return matrizSuma
     */
    public static int[][] sumarMatriz(int[][] matriz1,int[][] matriz2, int tamanio) {
        int[][] matrizSuma = new int[tamanio][tamanio];
        for (int i=0;i<tamanio; i++) {
            for (int j=0;j<tamanio;j++) 
                matrizSuma[i][j] = matriz1[i][j]+matriz2[i][j];
        }
        return matrizSuma;
    }

    /**
     * Funcion para mostrar la matriz
     * @param matriz
     * @param tamanio
     */
    public static void mostrarMatriz(int[][] matriz, int tamanio) {
        for (int i=0;i<tamanio; i++) {
            for (int j=0;j<tamanio;j++) 
                System.out.print(matriz[i][j]+"\t");
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        do {
            System.out.println("Introduzca un numero entre 2 y 5: ");
            numero = sc.nextInt();
        } while (numero<2 || numero>5);

        int[][] matriz1 = new int[numero][numero];
        int[][] matriz2 = new int[numero][numero];
        int[][] matrizResultado = new int[numero][numero];

        
        matriz1=crearMatriz(numero);
        matriz2=crearMatriz(numero);

        System.out.println("--- Mostramos matriz1 ---");
        mostrarMatriz(matriz1,numero);

        System.out.println("--- Mostramos matriz2 ---");
        mostrarMatriz(matriz2,numero);



        System.out.println("--- Mostramos matrizResultado ---");
        matrizResultado=sumarMatriz(matriz1,matriz2,numero);
        mostrarMatriz(matrizResultado,numero);
    }
}