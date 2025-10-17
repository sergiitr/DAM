public class ejercicio8 {
    public static int[][] mostrarMatriz(int[][] matriz, int filas, int columnas){
        for (int i=0; i<filas; i++) {
            for (int j=0;j<columnas; j++) 
                System.out.print(matriz[i][j]+"\t");
            System.out.println();
        }
        return matriz;
    }
    
    /**
     * Rellenamos los bordes con 1
     * @param matriz
     * @param filas
     * @param columnas
     * @return matriz actualizada
     */
    public static int[][] rellenar(int[][] matriz, int filas, int columnas) {
        for (int i=0; i<filas; i++) {
            for (int j=0;j<columnas; j++) {
                if ( i==0 || j==0 || i==filas-1 || j==columnas-1) {
                    matriz[i][j] = 1;
                }
            }
        }
        return matriz;
    }
    public static void main(String[] args) {
        final int FILAS=8;
        final int COLUMNAS=6;

        int[][] matriz = new int[FILAS][COLUMNAS];
        matriz = rellenar(matriz, FILAS, COLUMNAS);
        mostrarMatriz(matriz, FILAS, COLUMNAS);
    }
}
