/**
 * Movimiento del alfil
 */
import java.util.Scanner;

public class ejercicio4 {
    /**
     * Funcion para crear nuestras matrices con numeros random
     * @param filas
     * @param columnas
     * @return matriz
     */
    public static String[][] crearMatriz(int filas, int columnas) {
        String[][] matriz=new String[filas][columnas];
        for (int i=0;i<filas; i++) {
            for (int j=0;j<columnas;j++)
                matriz[i][j]="- ";
        }
        return matriz;
    }
    /**
     * Funcion para mostrar la matriz
     * @param matriz
     * @param filas
     * @param columnas
     */
    public static void mostrarMatriz(String[][] matriz, int filas, int columnas) {
        for (int i=0;i<filas; i++) {
            for (int j=0;j<columnas;j++) 
                System.out.print(matriz[i][j]+"\t");
            System.out.println("");
        }
    }

    /**
     * Ponemos el alfil en las coordenadas q hemos pedido x teclado
     * @param matriz
     * @param x
     * @param y
     * @return
     */
    public static String[][] ponerAlfil(String[][] matriz, int x, int y) {
        matriz[x][y] = String.valueOf((char) 0x2657);
        return matriz;
    }

    /**
     * Actualizamos el tablero y ponemos con una X las posiciones posibles del alfil
     * @param matriz
     * @param filas
     * @param columnas
     * @return
     */
    public static String[][] ponerX(String[][] matriz, int filas, int columnas) {
        String comp1=String.valueOf((char) 0x2657);
        String comp2="X ";
        int fAlf=0, cAlf =0;
        for (int i=0; i<filas-1; i++) {
            for (int j=0; j<columnas-1; j++) {
                if(matriz[i][j].equals(comp1)==true) {
                    fAlf=i;
                    cAlf=j;
                }
                if (matriz[i][j].equals(comp1)==true || matriz[i][j].equals(comp2)==true) 
                    matriz[i+1][j+1] = "X ";
            }
        }

        
        for (int i=fAlf; i>0; i--) {
            for (int j=cAlf; j>0; j--) {
                if (matriz[i][j].equals(comp1)==true || matriz[i][j].equals(comp2)==true) 
                    matriz[i-1][j-1] = "X ";
            }
        }

        for (int i=fAlf; i>0; i--) {
            for (int j=cAlf; j<columnas-1; j++) {
                if (matriz[i][j].equals(comp1)==true || matriz[i][j].equals(comp2)==true) 
                    matriz[i-1][j+1] = "X ";
            }
        }
        
        for (int i=fAlf; i<filas-1; i++) {
            for (int j=cAlf; j>0; j--) {
                if (matriz[i][j].equals(comp1)==true || matriz[i][j].equals(comp2)==true) 
                    matriz[i+1][j-1] = "X ";
            }
        }
        return matriz;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int FILAS=8;
        final int COLUMNAS=FILAS;

        String[][] tablero = new String[FILAS][COLUMNAS];

        tablero=crearMatriz(FILAS, COLUMNAS);
        mostrarMatriz(tablero, FILAS, COLUMNAS);

        int filaAlfil, columnaAlfil;
        do { 
            System.out.println("Introduzca la fila del alfil (0 al 7): ");
            filaAlfil = sc.nextInt();
        } while (filaAlfil<0 || filaAlfil>7);

        do { 
            System.out.println("Introduzca la columna del alfil (0 al 7): ");
            columnaAlfil = sc.nextInt();
        } while (columnaAlfil<0 || columnaAlfil>7);

        tablero=ponerAlfil(tablero,filaAlfil,columnaAlfil);
        mostrarMatriz(tablero, FILAS, COLUMNAS);

        System.out.println();
        System.out.println("Las casillas q sue puede mover el alfil son: ");
        tablero=ponerX(tablero, FILAS, COLUMNAS);
        mostrarMatriz(tablero, FILAS, COLUMNAS);
    }
}