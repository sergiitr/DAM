public class Rectangulo {

    public Rectangulo(String colorRelleno, String nombreRectangulo, int x1, int x2, int x3, int x4, int y1, int y2, int y3, int y4) {
        this.colorRelleno = colorRelleno;
        this.nombreRectangulo = nombreRectangulo;
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        this.y4 = y4;
    }

    public Rectangulo(int x1, int x2, int x3, int x4, int y1, int y2, int y3, int y4) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        this.y4 = y4;
    }

    public Rectangulo() {
        this.x1 = 1;
        this.x2 = 2;
        this.x3 = 3;
        this.x4 = 4;
        this.y1 = 1;
        this.y2 = 3;
        this.y3 = 2;
        this.y4 = 4;
    }

    public void posicion() {
        for (int i=0; i<this.FILA; i++) 
            for (int j=0; j<this.COLUMNA; j++) 
                this.tablero[i][j]="- ";
        
        
        for (int i=0; i<this.FILA; i++) {
            for (int j=0; j<this.COLUMNA; j++) {
                if(i==this.x1 && j==this.y1) 
                    this.tablero[i][j]="x ";
                
                if(i==this.x2 && j==this.y2)
                    this.tablero[i][j]="x ";
                
                if(i==this.x3 && j==this.y3)
                    this.tablero[i][j]="x ";
                
                if(i==this.x4 && j==this.y4)
                    this.tablero[i][j]="x ";
                
            }
        }

        for (int i=0; i<this.FILA; i++) {
            for (int j=0; j<this.COLUMNA; j++)
                System.out.print(this.tablero[i][j]);
            
            System.out.println();
        }
    }

    public String[][] getTablero() {
        return tablero;
    }

    
    public String getColorRelleno() {
        return colorRelleno;
    }

    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public String getNombreRectangulo() {
        return nombreRectangulo;
    }

    public void setNombreRectangulo(String nombreRectangulo) {
        this.nombreRectangulo = nombreRectangulo;
    }

    public int getCantRectangulos() {
        return cantRectangulos;
    }

    public void setCantRectangulos(int cantRectangulos) {
        this.cantRectangulos = cantRectangulos;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    public int getX4() {
        return x4;
    }

    public void setX4(int x4) {
        this.x4 = x4;
    }

    public int getY4() {
        return y4;
    }

    public void setY4(int y4) {
        this.y4 = y4;
    }

    private final int FILA=5;
    private final int COLUMNA=FILA;

    private String[][] tablero = new String[FILA][COLUMNA];

    private int x1;
    private int y1;

    private int x2;
    private int y2;

    private int x3;
    private int y3;

    private int x4;
    private int y4;
    

    private String colorRelleno;
    private String nombreRectangulo;
    private int cantRectangulos;
}