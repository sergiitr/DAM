public class ejercicio3 {
    public static int[][] rellenarMatriz(int[][] matriz, int filas, int columnas){
        for (int i=0; i<filas; i++)
            for (int j=0;j<columnas; j++) 
                matriz[i][j]=i+j;
        
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

    public static int[][] suma(int[][] matriz1, int[][] matriz2, int fil, int col) {
        int[][] suma = new int[fil][col];
        for (int i=0; i<fil; i++)
            for (int j=0;j<col; j++) 
                suma[i][j]=matriz1[i][j]+matriz2[i][j];

        return suma;
    }
    public static void main(String[] args) {
        final int FILAS=5;
        final int COLUMNAS=FILAS;
        System.out.println("Matriz 1");
        int[][] matriz1=new int[FILAS][COLUMNAS];
        matriz1=rellenarMatriz(matriz1,FILAS,COLUMNAS);
        mostrarMatriz(matriz1, FILAS, COLUMNAS);

        System.out.println("Matriz 2");
        int[][] matriz2=new int[FILAS][COLUMNAS];
        matriz1=rellenarMatriz(matriz2,FILAS,COLUMNAS);
        mostrarMatriz(matriz2, FILAS, COLUMNAS);

        System.out.println("Matriz suma");
        int[][] matrizSuma=new int[FILAS][COLUMNAS];
        matrizSuma=suma(matriz1, matriz2, FILAS, COLUMNAS);
        mostrarMatriz(matrizSuma, FILAS, COLUMNAS);
    }
}
