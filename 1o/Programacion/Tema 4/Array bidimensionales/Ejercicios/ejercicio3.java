public class ejercicio3 {
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
    public static void mostrarMatrizD(double[][] matriz, int filas, int columnas) {
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

    public static int[][] matrizAdjunta(int[][] matriz, int filas, int columnas) {
        int[][] mAdjunta = new int[filas][columnas];

        mAdjunta[0][0]=     determinanteMatriz2(matriz[1][1],matriz[1][2],matriz[2][1],matriz[2][2]);
        mAdjunta[0][1]=(-1)*determinanteMatriz2(matriz[1][0],matriz[1][2],matriz[2][0],matriz[2][2]);
        mAdjunta[0][2]=     determinanteMatriz2(matriz[1][0],matriz[1][1],matriz[2][0],matriz[2][1]);
        mAdjunta[1][0]=(-1)*determinanteMatriz2(matriz[0][1],matriz[0][2],matriz[2][1],matriz[2][2]);
        mAdjunta[1][1]=     determinanteMatriz2(matriz[0][0],matriz[0][2],matriz[2][0],matriz[2][2]);
        mAdjunta[1][2]=(-1)*determinanteMatriz2(matriz[0][0],matriz[0][1],matriz[2][0],matriz[2][1]);
        mAdjunta[2][0]=     determinanteMatriz2(matriz[0][1],matriz[0][2],matriz[1][1],matriz[1][2]);
        mAdjunta[2][1]=(-1)*+determinanteMatriz2(matriz[0][0],matriz[0][2],matriz[1][0],matriz[1][2]);
        mAdjunta[2][2]=     determinanteMatriz2(matriz[0][0],matriz[0][1],matriz[1][0],matriz[1][1]);
        return mAdjunta;
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
     * Funcion que devuelve el determinante de una matriz
     * @param matriz
     * @param filas
     * @param columnas
     * @return determinante
     */
    public static int determinanteMatriz2(int a,int b, int c,int d) {
        int determinante = 0;
        
        determinante = a*d-b*c;

        return determinante;
    }

    /**
     * Funcion que devuelve el determinante de una matriz
     * @param matriz
     * @param filas
     * @param columnas
     * @return determinante
     */
    public static int determinanteMatriz3(int[][] matriz) {
        int determinante = 0;
        
        determinante = matriz[0][0]*matriz[1][1]*matriz[2][2]
                     + matriz[0][1]*matriz[1][2]*matriz[2][0]
                     + matriz[0][2]*matriz[1][0]*matriz[2][1]
                     - matriz[0][2]*matriz[1][1]*matriz[2][0]
                     - matriz[0][0]*matriz[1][2]*matriz[2][1]
                     - matriz[0][1]*matriz[1][0]*matriz[2][2];

        return determinante;
    }

    public static double[][] matrizInversa(int[][] matriz, int filas, int columnas) {
        double[][] matrizInversa = new double[filas][columnas];
        int determinante = determinanteMatriz3(matriz);
        int[][] matrizAdjunta = new int[filas][columnas];
        int[][] matrizAdjuntaTraspuesta = new int[filas][columnas];
        matrizAdjunta = matrizAdjunta(matriz, filas, columnas);
        matrizAdjuntaTraspuesta = matrizTraspuesta(matrizAdjunta, filas, columnas);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizInversa[i][j] = (double)matrizAdjuntaTraspuesta[i][j]/determinante;
            }
        }

        return matrizInversa;
    }

    public static void main(String[] args) {
        final int FILAS=3;
        final int COLUMNAS=FILAS;
        //PARAMETROS ESENCIALES
        int[][] matriz = {{2,0,1},{3,0,0},{5,1,1}};
        double[][] matrizInversa = new double[FILAS][COLUMNAS];

        

        System.out.println("Creamos matriz");

        System.out.println("Mostramos matriz");
        mostrarMatriz(matriz, FILAS, COLUMNAS);

        
        //PARA COMPROBAR
        System.out.println("---MATRIZ ADJUNTA ---"); // Para la adjunta la hace bien
        int[][] matrizAdjunta = new int[FILAS][COLUMNAS];
        matrizAdjunta=matrizAdjunta(matriz, FILAS, COLUMNAS);
        mostrarMatriz(matrizAdjunta,FILAS,COLUMNAS);

        System.out.println("\nel determinante es:"+determinanteMatriz3(matriz)+"\n");
        
        // SOLUCION
        System.out.println("Mostramos matriz inversa");
        matrizInversa=matrizInversa(matriz, FILAS, COLUMNAS);
        mostrarMatrizD(matrizInversa, FILAS, COLUMNAS);
    }
}
