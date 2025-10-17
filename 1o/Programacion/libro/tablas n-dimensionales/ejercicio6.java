import java.util.Random;

public class ejercicio6 {
    /**
     * Rellenamos matriz con la suma 
     * @param matriz
     * @param filas
     * @param columnas
     * @return
     */
    public static int[][] rellenarMatriz(int[][] matriz, int filas, int columnas){
        for (int i=0; i<filas; i++)
            for (int j=0;j<columnas; j++) 
                matriz[i][j]=i+j;
        
        return matriz;
    }

    /**
     * Rellenamos matriz con randoms
     * @param matriz
     * @param filas
     * @param columnas
     * @return
     */
    public static int[][] rellenarMatrizR(int[][] matriz, int filas, int columnas){
        Random random = new Random();
        for (int i=0; i<filas; i++)
            for (int j=0;j<columnas; j++) 
                matriz[i][j]=random.nextInt(5);
        
        return matriz;
    }
    
    public static int[][] mostrarMatriz(int[][] matriz, int filas, int columnas){
        for (int i=0; i<filas; i++) {
            for (int j=0;j<columnas; j++) 
                System.out.print(matriz[i][j]+"\t");
            System.out.println();
        }
        return matriz;
    }

    /**
     * Vemos la suma de cada fila
     * @param matriz
     * @param filas
     * @param columnas
     */
    public static void sumaFila(int[][] matriz, int filas, int columnas) {
        int sumaF=0;
        for (int i=0; i<filas; i++) {
            for (int j=0; j<columnas; j++) 
                sumaF+=matriz[i][j];
            
            System.out.println("Fila "+i+": "+sumaF);
            sumaF=0;
        }
    }
    
    /**
     * Vemos la suma de cada columna
     * @param matriz
     * @param filas
     * @param columnas
     */
    public static void sumaColumna(int[][] matriz, int filas, int columnas) {
        int sumaC=0;
        for (int i=0; i<filas; i++) {
            for (int j=0; j<columnas; j++) 
                sumaC+=matriz[j][i];
            
            System.out.println("Fila "+i+": "+sumaC);
            sumaC=0;
        }
    }

    public static void main(String[] args) {
        final int FILAS=10;
        final int COLUMNAS=FILAS;
        System.out.println("Matriz 1");
        int[][] matriz1=new int[FILAS][COLUMNAS];
        matriz1=rellenarMatriz(matriz1,FILAS,COLUMNAS);
        mostrarMatriz(matriz1, FILAS, COLUMNAS);
        sumaFila(matriz1,FILAS, COLUMNAS);


        System.out.println();
        System.out.println("Matriz suma");
        int[][] matriz2=new int[FILAS][COLUMNAS];
        matriz2=rellenarMatrizR(matriz2,FILAS, COLUMNAS);
        mostrarMatriz(matriz2, FILAS, COLUMNAS);
        sumaColumna(matriz2, FILAS, COLUMNAS);
    }
}
