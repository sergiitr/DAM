
import java.util.Scanner;

public class ejercicio2 {
    /**
     * Funcion para mostrar la matriz
     * @param matriz
     * @param filas
     * @param columnas
     */
    public static void mostrarMatriz(int[][] matriz, int filas, int columnas) {
        for (int i=0;i<filas; i++) {
            for (int j=0;j<columnas;j++) 
                System.out.print(matriz[i][j]+"\t");
            System.out.println("");
        }
    }

    /**
     * Funcion para crear nuestras matrices con numeros random
     * @param filas
     * @param columnas
     * @return matriz
     */
    public static int[][] crearMatriz(int filas, int columnas) {
        int[][] matriz=new int[filas][columnas];
        for (int i=0;i<filas; i++) {
            for (int j=0;j<columnas;j++)
                matriz[i][j]=(int)(Math.random()*10);
        }
        return matriz;
    }

    /**
     * Funcion que devuelve el determinante de una matriz
     * @param matriz
     * @param filas
     * @param columnas
     * @return determinante
     */
    public static int determinanteMatriz(int[][] matriz, int filas, int columnas) {
        int determinante = 0;
        
        determinante = matriz[0][0]*matriz[1][1]*matriz[2][2]
                     + matriz[0][1]*matriz[1][2]*matriz[2][0]
                     + matriz[0][2]*matriz[1][0]*matriz[2][1]
                     - matriz[0][2]*matriz[1][1]*matriz[2][0]
                     - matriz[0][0]*matriz[1][2]*matriz[2][1]
                     - matriz[0][1]*matriz[1][0]*matriz[2][2];

        return determinante;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int FILAS = 3;
        final int COLUMNAS = FILAS;
        
        int[][] matriz = new int[FILAS][COLUMNAS];

        matriz=crearMatriz(FILAS, COLUMNAS);

        System.out.println("--- Mostramos la matriz ---");
        mostrarMatriz(matriz, FILAS, COLUMNAS);
        
        System.out.println("El determinante de la matriz es: "+determinanteMatriz(matriz, FILAS, COLUMNAS));

    }
}
