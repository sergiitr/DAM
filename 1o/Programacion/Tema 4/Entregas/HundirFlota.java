/**
 * Juego hundir la flota
 * @author Sergio Trillo
 */
import java.util.Scanner;

public class HundirFlota {
    /**
     * Creamos el tablero 
     * @param matriz
     * @param filas
     * @param columnas
     * @return matriz actualizada
     */
    public static String[][] crearTablero(String[][] matriz, int filas, int columnas){
        for (int i=0; i<filas; i++)
            for (int j=0; j<columnas; j++)
                matriz[i][j]="- ";

        return matriz;
    }

    /**
     * Mostramos el tablero de juego
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
     * Turno del humano para posicionar su barco
     * @param tableroHumano
     * @param tableroMaquina
     * @param filas
     * @param columnas
     */
    public static void turnoHumanoCrear(String[][] tableroHumano, String[][] tableroMaquina, int filas, int columnas) {
        System.out.println("Tu turno para posiconar: ");
        insertarPieza(tableroHumano, filas, columnas);
        mostrarTablero(tableroHumano, filas, columnas);
        turnoMaquinaCrear(tableroHumano,tableroMaquina, filas, columnas);
    }

    /**
     * Turno de la maquina para posicionar su barco
     * @param tableroHumano
     * @param tableroMaquina
     * @param filas
     * @param columnas
     */
    public static void turnoMaquinaCrear(String[][] tableroHumano, String[][] tableroMaquina, int filas, int columnas) {
        System.out.println("Turno de la maquina para posicionar: ");
        insertarPieza(tableroMaquina, filas, columnas);
        mostrarTablero(tableroMaquina, filas, columnas);
        turnoHumano(tableroHumano, tableroMaquina, filas, columnas);
    }

    /**
     * Metodo para insertar el barco a cada tablero
     * @param matriz
     * @param filas
     * @param columnas
     */
    public static void insertarPieza(String[][] matriz, int filas, int columnas) {
        Scanner sc = new Scanner(System.in);
        int pieza, orientacion, fil,col;
        System.out.println("--- Dime la pieza que quieres insertar ---");
        System.out.println("1 Barco pequeño (2 casillas)");
        System.out.println("2 Barco greande (4 casillas)");
        do { 
            pieza = sc.nextInt();
        } while (pieza!=1 && pieza!=2);
        System.out.println("--- Dime como quieres insertar la pieza ---");
        System.out.println("1 Vertical");
        System.out.println("2 Horizontal");
        do { 
            orientacion = sc.nextInt();
        } while (orientacion!=1 && orientacion!=2);

        if (orientacion==1){
            System.out.println("Di las cordenadas en la que quieres iniciarlo, (se lee de arriba a abajo y de izquierda a derecha)");
            do{
                System.out.print("Fila (del 0 al "+(filas-1)+"): ");
                fil=sc.nextInt();
            } while( fil<0 || fil+2>filas );

            do{
                System.out.print("Columna (del 0 al "+(columnas-1)+"): ");
                col=sc.nextInt();
            } while( col<0 || col+2>columnas );
        } else {
            System.out.println("Di las cordenadas en la que quieres iniciarlo, (se lee de arriba a abajo y de izquierda a derecha)");
            do{
                System.out.print("Fila (del 0 al "+(filas-1)+"): ");
                fil=sc.nextInt();
            } while( fil<0 || fil+4>filas );

            do{
                System.out.print("Columna (del 0 al "+(columnas-1)+"): ");
                col=sc.nextInt();
            } while( col<0 || col+4>columnas );
        }

        if (pieza==1)
            barcoPequeno(matriz,orientacion,fil,col);
        else
            barcoGrande(matriz,orientacion,fil,col);
        
    }

    /**
     * Metemos el barco pequeño al tablero
     * @param matriz
     * @param orientacion
     * @param posX
     * @param posY
     */
    public static void barcoPequeno(String[][] matriz, int orientacion, int posX, int posY) {
        final String POS_BARCO="x ";
        if (orientacion==1) {   // Vertical
            matriz[posX][posY]=POS_BARCO;
            matriz[posX+1][posY]=POS_BARCO;
        } else {                // Horizontal
            matriz[posX][posY]=POS_BARCO;
            matriz[posX][posY+1]=POS_BARCO;
        }
    }

    /**
     * Metemos el barco pequeño al tablero
     * @param matriz
     * @param orientacion
     * @param posX
     * @param posY
     */
    public static void barcoGrande(String[][] matriz, int orientacion, int posX, int posY) {
        final String POS_BARCO="x ";
        if (orientacion==1) {   // Vertical
            matriz[posX][posY]=POS_BARCO;
            matriz[posX+1][posY]=POS_BARCO;
            matriz[posX+2][posY]=POS_BARCO;
            matriz[posX+3][posY]=POS_BARCO;
        } else {                // Horizontal
            matriz[posX][posY]=POS_BARCO;
            matriz[posX][posY+1]=POS_BARCO;
            matriz[posX][posY+2]=POS_BARCO;
            matriz[posX][posY+3]=POS_BARCO;
        }
    }

    /**
     * Turno del humano para atacar
     * @param tableroHumano
     * @param tableroMaquina
     * @param filas
     * @param columnas
     */
    public static void turnoHumano(String[][] tableroHumano, String[][] tableroMaquina, int filas, int columnas) {
        Scanner sc = new Scanner(System.in);
        int x,y, contadorX=0;
        String posBarco="x ";
        System.out.println("Turno del humano para atacar: ");
        
        System.out.println("Inserte dos coordenadas: ");
        System.out.print("Fila: ");
        x = sc.nextInt();
        System.out.print("Columna: ");
        y = sc.nextInt();
        
        String[][] t = new String[filas][columnas];
        t=ataqueHumano(tableroMaquina, x, y, filas, columnas);
        tableroHumano=t;
        for (int i=0;i<filas;i++)
            for(int j=0;j<columnas;j++)
                if(tableroMaquina[i][j].equals(posBarco)==true) 
                    contadorX++;
        
        if (contadorX==0)
            ganador();
        else
            turnoMaquina(tableroHumano, tableroMaquina, filas, columnas);
    }

    /**
     * Se le pasan las coordenas del usuario. Si acierta, se actualiza el tablero, si no, sale el mensaje de agua
     * @param tableroMaquina
     * @param x
     * @param y
     * @param filas
     * @param columnas
     * @return tableroMaquina actualizado
     */
    public static String[][] ataqueHumano(String[][] tableroMaquina, int x, int y,int filas, int columnas){
        String barco="x ";
        String tocado="t ";

        if(tableroMaquina[x][y].equals(barco)==true)
            tableroMaquina[x][y]=tocado;
        else
            System.out.print("Agua");

        return tableroMaquina;
    }

    /**
     * Turno del humano para atacar
     * @param tableroHumano
     * @param tableroMaquina
     * @param filas
     * @param columnas
     */
    public static void turnoMaquina(String[][] tableroHumano, String[][] tableroMaquina, int filas, int columnas) {
        Scanner sc = new Scanner(System.in);
        int x,y, contadorX=0;

        System.out.println("Turno de la maquina para atacar: ");
        
        System.out.println("Inserte dos coordenadas: ");
        System.out.print("Fila: ");
        x = sc.nextInt();
        System.out.print("Columna: ");
        y = sc.nextInt();
        
        tableroHumano=ataqueMaquina(tableroHumano,x,y,filas,columnas);

        for (int i=0;i<filas;i++)
            for(int j=0;j<columnas;j++)
                if(tableroHumano[i][j].equals("x ")==true) 
                    contadorX++;
        
        if (contadorX==0) {
            System.out.println("GANA LA MAQUINA");
            ganador();
        }else
            turnoHumano(tableroHumano, tableroMaquina, filas, columnas);
    }

    /**
     * Se le pasan las coordenas de la maquina. Si acierta, se actualiza el tablero, si no, sale el mensaje de agua
     * @param tableroMaquina
     * @param x
     * @param y
     * @param filas
     * @param columnas
     * @return tableroHumano actualizado
     */
    public static String[][] ataqueMaquina(String[][] tableroHumano,int x, int y,int filas, int columnas){
        String barco="x ";
        String tocado="t ";

        if(tableroHumano[x][y].equals(barco)==true)
            tableroHumano[x][y]=tocado;
        else
            System.out.print("Agua");

        return tableroHumano;
    }

    /**
     * Mensaje fin de partida
     * Se muestra cuando hay un ganador
     */
    public static void ganador() {
        System.out.println("FIN DE PARTIDA");
    }

    public static void main(String[] args) {
        final int FILAS=4;
        final int COLUMNAS=FILAS;

        String[][] tableroHumano = new String[FILAS][COLUMNAS];
        String[][] tableroMaquina = new String[FILAS][COLUMNAS];
        
        tableroHumano=crearTablero(tableroHumano,FILAS,COLUMNAS);
        tableroMaquina=crearTablero(tableroMaquina,FILAS,COLUMNAS);
        turnoHumanoCrear(tableroHumano,tableroMaquina,FILAS,COLUMNAS);
    }
}
