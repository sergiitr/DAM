/**
 * Matriz trapuesta
 */
public class ejercicio1 {
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
     * Funcion para devolver la matriz Transpuesta
     * @param matriz
     * @param filas
     * @param columnas
     * @return matrizTraspuesta
     */
    public static int[][] matrizTraspuesta(int[][] matriz, int filas, int columnas) {
        int[][] matrizTraspuesta=new int[columnas][filas];
        for (int i=0; i<filas; i++) {
            for (int j=0; j<columnas; j++) {
                matrizTraspuesta[j][i]=matriz[i][j];
            }
        }
        return matrizTraspuesta;
    }

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

    public static void main(String[] args) {
        final int FILA=3;
        final int COLUMNA=4;
        int[][] matriz1=new int[FILA][COLUMNA];

        int[][] matrizTraspuesta=new int[COLUMNA][FILA];
        matriz1=crearMatriz(FILA,COLUMNA);
        System.out.println("Matriz Original: ");
        mostrarMatriz(matriz1, FILA, COLUMNA);

        System.out.println("");
        matrizTraspuesta=matrizTraspuesta(matriz1,FILA,COLUMNA);
        System.out.println("Matiz Transpuesta: ");
        mostrarMatriz(matrizTraspuesta, COLUMNA, FILA);
    }
}
