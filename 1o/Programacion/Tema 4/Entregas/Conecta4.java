
/**
 * Conecta 4
 * @author Sergio Trillo Rodriguez
 */
import java.util.Random;
import java.util.Scanner;

public class Conecta4 {
    /**
     * Creamos el tablero de juego
     * @param matriz
     * @param filas
     * @param columnas
     * @return matriz
     */
    public static String[][] crearTablero(String[][] matriz, int filas, int columnas) {
        for (int i=0; i<filas; i++)
            for (int j=0; j<columnas; j++)
                matriz[i][j]="- ";

        return matriz;
    }

    /**
     * Se muestra el tablero
     * @param matriz
     * @param filas
     * @param columnas
     */
    public static void mostrarTablero(String[][] matriz, int filas, int columnas) {
        for (int i=0; i<filas; i++) {
            for (int j=0; j<columnas; j++)
                System.out.print(matriz[i][j]);
            System.out.println();
        }
    }

    /**
     * Hacemos el movimiento del humano. Insertamos la columna en la q vamos a insertar la ficha
     * @param matriz
     * @param filas
     * @param columnas
     */
    public static void turnoHumano(String[][] matriz, int filas, int columnas) {
        Scanner sc=new Scanner(System.in);
        int col;
        System.out.println("--- TURNO HUMANO ---");
        do {
            System.out.print("Introduzca la columna (0 a "+(columnas-1)+"): ");
            col=sc.nextInt();
        } while (col<0 || col>=columnas || columnaLlena(matriz, col, filas));

        matriz=insertaHumano(matriz, col, filas, columnas);
        mostrarTablero(matriz, filas, columnas);

        if (compruebaGanador(matriz))
            System.out.println("Ha ganado el humano");
        else {
            if (empate(matriz, filas, columnas))
                System.out.println("Empate");
            else
                turnoMaquina(matriz, filas, columnas);
        }
    }

    /**
     * Hacemos el movimiento de la maquina. 
     * El random insertara la columna en la q va a insertar la ficha
     * @param matriz
     * @param filas
     * @param columnas
     */
    public static void turnoMaquina(String[][] matriz, int filas, int columnas) {
        int col;
        Random rd=new Random();
        System.out.println("--- TURNO MAQUINA ---");
        do {
            col=rd.nextInt(0, columnas);
        } while (columnaLlena(matriz, col, filas));

        matriz=insertaMaquina(matriz, col, filas, columnas);
        mostrarTablero(matriz, filas, columnas);

        if (compruebaGanador(matriz))
            System.out.println("Ha ganado la maquina");
        else {
            if (empate(matriz, filas, columnas))
                System.out.println("Empate");
            else
                turnoHumano(matriz, filas, columnas);
        }
    }

    /**
     * Comprueba si la fila ya está llena o no
     * @param matriz
     * @param columna
     * @param filas
     * @return true si está llena, false si no
     */
    public static boolean columnaLlena(String[][] matriz, int columna, int filas) {
        return !matriz[0][columna].equals("- ");
    }

    /**
     * Inserta la ficha del humano en el tablero
     * @param matriz
     * @param columnaInsertada
     * @param filas
     * @param columnas
     * @return matriz
     */
    public static String[][] insertaHumano(String[][] matriz, int columnaInsertada, int filas, int columnas) {
        int contador=0;
        for (int i=(filas-1); i>=0; i--)
            for (int j=0; j<columnas; j++)
                if (j==columnaInsertada)
                    if (!matriz[i][j].equals("- "))
                        contador++;

        for (int i=(filas-1); i>=0; i--)
            for (int j=0; j<columnas; j++)
                if (j==columnaInsertada) {
                    if (matriz[i][j].equals("- ")) {
                        matriz[i][j]="o ";
                        return matriz;
                    } else {
                        matriz[i-contador][j]="o ";
                        return matriz;
                    }
                }

        return matriz;
    }

    /**
     * Inserta la ficha de la maquina en el tablero
     * @param matriz
     * @param columnaInsertada
     * @param filas
     * @param columnas
     * @return matriz
     */
    public static String[][] insertaMaquina(String[][] matriz, int columnaInsertada, int filas, int columnas) {
        int contador=0;
        for (int i=(filas-1); i>=0; i--)
            for (int j=0; j<columnas; j++)
                if (j==columnaInsertada)
                    if (!matriz[i][j].equals("- "))
                        contador++;

        for (int i=(filas-1); i>=0; i--)
            for (int j=0; j<columnas; j++)
                if (j==columnaInsertada) {
                    if (matriz[i][j].equals("- ")) {
                        matriz[i][j]="x ";
                        return matriz;
                    } else {
                        matriz[i-contador][j]="x ";
                        return matriz;
                    }
                }

        return matriz;
    }

    /**
     * Comprueba si hay ganador
     * @param matriz
     * @return true si hay ganador, false si no
     */
    public static boolean compruebaGanador(String[][] matriz) {
        String circulo="o ", equis="x ";
        if ( (matriz[0][0].equals(circulo) && matriz[0][1].equals(circulo) && matriz[0][2].equals(circulo) && matriz[0][3].equals(circulo)) || (matriz[1][0].equals(circulo) && matriz[1][1].equals(circulo) && matriz[1][2].equals(circulo) && matriz[1][3].equals(circulo))  ||
             (matriz[2][0].equals(circulo) && matriz[2][1].equals(circulo) && matriz[2][2].equals(circulo) && matriz[2][3].equals(circulo)) || (matriz[3][0].equals(circulo) && matriz[3][1].equals(circulo) && matriz[3][2].equals(circulo) && matriz[3][3].equals(circulo))  ||
             (matriz[0][0].equals(circulo) && matriz[1][1].equals(circulo) && matriz[2][2].equals(circulo) && matriz[3][3].equals(circulo)) || (matriz[0][3].equals(circulo) && matriz[1][2].equals(circulo) && matriz[2][1].equals(circulo) && matriz[3][0].equals(circulo))  ||
             (matriz[0][3].equals(circulo) && matriz[1][3].equals(circulo) && matriz[2][3].equals(circulo) && matriz[3][3].equals(circulo)) || (matriz[0][2].equals(circulo) && matriz[1][2].equals(circulo) && matriz[2][2].equals(circulo) && matriz[3][2].equals(circulo))  ||
             (matriz[0][1].equals(circulo) && matriz[1][1].equals(circulo) && matriz[2][1].equals(circulo) && matriz[3][1].equals(circulo)) || (matriz[0][0].equals(circulo) && matriz[1][0].equals(circulo) && matriz[2][0].equals(circulo) && matriz[3][0].equals(circulo)) )
            return true;
        else if ( (matriz[0][0].equals(equis) && matriz[0][1].equals(equis) && matriz[0][2].equals(equis) && matriz[0][3].equals(equis)) || (matriz[1][0].equals(equis) && matriz[1][1].equals(equis) && matriz[1][2].equals(equis) && matriz[1][3].equals(equis)) ||
                  (matriz[2][0].equals(equis) && matriz[2][1].equals(equis) && matriz[2][2].equals(equis) && matriz[2][3].equals(equis)) || (matriz[3][0].equals(equis) && matriz[3][1].equals(equis) && matriz[3][2].equals(equis) && matriz[3][3].equals(equis)) ||
                  (matriz[0][0].equals(equis) && matriz[1][1].equals(equis) && matriz[2][2].equals(equis) && matriz[3][3].equals(equis)) || (matriz[0][3].equals(equis) && matriz[1][2].equals(equis) && matriz[2][1].equals(equis) && matriz[3][0].equals(equis)) ||
                  (matriz[0][3].equals(equis) && matriz[1][3].equals(equis) && matriz[2][3].equals(equis) && matriz[3][3].equals(equis)) || (matriz[0][2].equals(equis) && matriz[1][2].equals(equis) && matriz[2][2].equals(equis) && matriz[3][2].equals(equis)) ||
                  (matriz[0][1].equals(equis) && matriz[1][1].equals(equis) && matriz[2][1].equals(equis) && matriz[3][1].equals(equis)) || (matriz[0][0].equals(equis) && matriz[1][0].equals(equis) && matriz[2][0].equals(equis) && matriz[3][0].equals(equis)) )
            return true;

        return false;
    }

    /**
     * Hacemos el movimiento del humano. Insertamos la columna en la q vamos a insertar la ficha
     * @param matriz
     * @param filas
     * @param columnas
     */
    public static void turnoHumano2(String[][] matriz, int filas, int columnas) {
        Scanner sc=new Scanner(System.in);
        int col;
        System.out.println("--- TURNO HUMANO 1 ---");
        do {
            System.out.print("Introduzca la columna (0 a "+(columnas-1)+"): ");
            col=sc.nextInt();
        } while (col<0 || col>=columnas || columnaLlena(matriz, col, filas)==true);
        matriz=insertaHumano2(matriz, col, filas, columnas);
        mostrarTablero(matriz, filas, columnas);
        if (compruebaGanador(matriz))
            System.out.println("Ha ganado el humano 1");
        else {
            if (empate(matriz, filas, columnas))
                System.out.println("Empate");
            else
                turnoHumano3(matriz, filas, columnas);
        }
    }

    /**
     * Hacemos el movimiento del humano. Insertamos la columna en la q vamos a insertar la ficha
     * @param matriz
     * @param filas
     * @param columnas
     */
    public static void turnoHumano3(String[][] matriz, int filas, int columnas) {
        Scanner sc=new Scanner(System.in);
        int col;
        System.out.println("--- TURNO HUMANO 2 ---");
        do {
            System.out.print("Introduzca la columna (0 a "+(columnas-1)+"): ");
            col=sc.nextInt();
        } while (col<0 || col>=columnas || columnaLlena(matriz, col, filas));
        matriz=insertaHumano3(matriz, col, filas, columnas);
        mostrarTablero(matriz, filas, columnas);
        if (compruebaGanador2(matriz))
            System.out.println("Ha ganado el humano 2");
        else {
            if (empate(matriz, filas, columnas))
                System.out.println("Empate");
            else
                turnoHumano2(matriz, filas, columnas);
        }
    }

    /**
     * Comprueba el ganador del humano vs humano
     * @param matriz
     * @return true si hay ganador false si no
     */
    public static boolean compruebaGanador2(String[][] matriz) {
        String circulo="o ", equis="x ";
        for (int i=0; i<6; i++)
            for (int j=0; j<4; j++) {
                if (matriz[i][j].equals(circulo) && matriz[i][j+1].equals(circulo) && matriz[i][j+2].equals(circulo) && matriz[i][j+3].equals(circulo))
                    return true;
                if (matriz[i][j].equals(equis) && matriz[i][j+1].equals(equis) && matriz[i][j+2].equals(equis)  && matriz[i][j+3].equals(equis))
                    return true;
            }
        
        for (int j=0; j<7; j++) 
            for (int i=0; i<3; i++) {
                if (matriz[i][j].equals(circulo) && matriz[i+1][j].equals(circulo) && matriz[i+2][j].equals(circulo) && matriz[i+3][j].equals(circulo))
                    return true;
                if (matriz[i][j].equals(equis) && matriz[i+1][j].equals(equis) && matriz[i+2][j].equals(equis) && matriz[i+3][j].equals(equis))
                    return true;

            }
        
        for (int i=0; i<3; i++) 
            for (int j=0; j<4; j++) {
                if (matriz[i][j].equals(circulo) && matriz[i+1][j+1].equals(circulo) && matriz[i+2][j+2].equals(circulo) && matriz[i+3][j+3].equals(circulo))
                    return true;
                if (matriz[i][j].equals(equis) && matriz[i+1][j+1].equals(equis) && matriz[i+2][j+2].equals(equis) && matriz[i+3][j+3].equals(equis))
                    return true;
            }
        
        for (int i=0; i<3; i++) 
            for (int j=3; j<7; j++) {
                if (matriz[i][j].equals(circulo) && matriz[i+1][j-1].equals(circulo) && matriz[i+2][j-2].equals(circulo) && matriz[i+3][j-3].equals(circulo))
                    return true;
                if (matriz[i][j].equals(equis) && matriz[i+1][j-1].equals(equis) && matriz[i+2][j-2].equals(equis) && matriz[i+3][j-3].equals(equis))
                    return true;
            }
        
        return false;
    }

    /**
     * Inserta la ficha del primer humano
     * @param matriz
     * @param columnaInsertada
     * @param filas
     * @param columnas
     * @return tablero actualizado
     */
    public static String[][] insertaHumano2(String[][] matriz, int columnaInsertada, int filas, int columnas) {
        int contador=0;
        for (int i=(filas-1); i>=0; i--)
            for (int j=0; j<columnas; j++)
                if (j==columnaInsertada)
                    if (!matriz[i][j].equals("- "))
                        contador++;

        for (int i=(filas-1); i>=0; i--)
            for (int j=0; j<columnas; j++)
                if (j==columnaInsertada) {
                    if (matriz[i][j].equals("- ")) {
                        matriz[i][j]="o ";
                        return matriz;
                    } else {
                        matriz[i-contador][j]="o ";
                        return matriz;
                    }
                }
        
        return matriz;
    }

    /**
     * Inserta la ficha del segundo humano
     * @param matriz
     * @param columnaInsertada
     * @param filas
     * @param columnas
     * @return tablero actualizado
     */
    public static String[][] insertaHumano3(String[][] matriz, int columnaInsertada, int filas, int columnas) {
        int contador=0;
        for (int i=(filas-1); i>=0; i--)
            for (int j=0; j<columnas; j++)
                if (j==columnaInsertada)
                    if (!matriz[i][j].equals("- "))
                        contador++;

        for (int i=(filas-1); i>=0; i--)
            for (int j=0; j<columnas; j++) 
                if (j==columnaInsertada) {
                    if (matriz[i][j].equals("- ")) {
                        matriz[i][j]="x ";
                        return matriz;
                    } else {
                        matriz[i-contador][j]="x ";
                        return matriz;
                    }
                }
        
        return matriz;
    }

    /**
     * Todas las casillas estan rellenas y no hay ganador
     * @param matriz
     * @param filas
     * @param columnas
     * @return true si hay empate, false si no
     */
    public static boolean empate(String[][] matriz, int filas, int columnas) {
        int contador=0;
        for (int i=0; i<filas; i++)
            for (int j=0; j<columnas; j++)
                if (matriz[i][j].equals("- "))
                    contador++;

        return contador <= 0;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Desea jugar contra una maquina (0) o conta un humano (1)");
            opcion=sc.nextInt();
        } while (opcion > 1 || opcion<0);
        if (opcion==0) {
            final int FILAS=4;
            final int COLUMNAS=4;
            String matriz[][]=new String[FILAS][COLUMNAS];
            System.out.println();
            matriz=crearTablero(matriz, FILAS, COLUMNAS);
            mostrarTablero(matriz, FILAS, COLUMNAS);
            System.out.println();
            turnoHumano(matriz, FILAS, COLUMNAS);
        } else {
            final int FILAS=6;
            final int COLUMNAS=7;
            String matriz[][]=new String[FILAS][COLUMNAS];
            System.out.println();
            matriz=crearTablero(matriz, FILAS, COLUMNAS);
            mostrarTablero(matriz, FILAS, COLUMNAS);
            System.out.println();
            turnoHumano2(matriz, FILAS, COLUMNAS);
        }
    }
}
