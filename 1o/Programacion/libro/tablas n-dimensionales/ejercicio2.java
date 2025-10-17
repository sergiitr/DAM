public class ejercicio2 {
    public static int[][] mostrarMatriz(int[][] matriz, int filas, int columnas){
        for (int i=0; i<filas; i++) {
            for (int j=0;j<columnas; j++) 
                System.out.print(matriz[i][j]+" ");
            System.out.println();
        }

        return matriz;
    }
    public static boolean simetrica(int[][] tabla, int filas, int columnas) {
        for (int i=0; i<filas; i++)
            for (int j=0;j<columnas; j++) 
                if (tabla[i][j] != tabla[j][i]) 
                    return false;
   
        return true;
    }

    public static int[][] rellenarMatriz(int[][] matriz, int filas, int columnas){
        for (int i=0; i<filas; i++)
            for (int j=0;j<columnas; j++) 
                matriz[i][j]=i+j;
        
        return matriz;
    }

    public static void main(String[] args) {
        final int FILAS=4;
        final int COLUMNAS=FILAS;
        int[][] tabla=new int[FILAS][COLUMNAS];

        tabla = rellenarMatriz(tabla, FILAS, COLUMNAS);

        mostrarMatriz(tabla, FILAS, COLUMNAS);
        System.out.println();
        boolean valor = simetrica(tabla, FILAS, COLUMNAS);
        if (valor == true)
            System.out.println("Es simetrica");
        else 
            System.out.println("No es simetrica");
    }
}
