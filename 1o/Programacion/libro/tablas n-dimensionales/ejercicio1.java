public class ejercicio1 {
    public static int[][] mostrarMatriz(int[][] matriz, int filas, int columnas){
        for (int i=0; i<filas; i++) {
            for (int j=0;j<columnas; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }

        return matriz;
    }
    public static int[][] rellenarMatriz(int[][] matriz, int filas, int columnas){
        for (int i=0; i<filas; i++) {
            for (int j=0;j<columnas; j++) {
                matriz[i][j]=i+j;
            }
        }
        return matriz;
    }
    public static void main(String[] args) {
        final int FILAS=5;
        final int COLUMNAS=FILAS;
        int[][] tabla=new int[FILAS][COLUMNAS];
        
        tabla=rellenarMatriz(tabla,FILAS,COLUMNAS);
        
        mostrarMatriz(tabla, FILAS, COLUMNAS);
    }
}