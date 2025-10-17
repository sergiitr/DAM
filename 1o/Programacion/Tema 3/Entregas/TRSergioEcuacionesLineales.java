/**
 * Clase Ecuaciones Lineales
 * @author Sergio Trilo Rodriguez
 */
public class TRSergioEcuacionesLineales {
    /**
     * Constructor x defecto
     */
    public TRSergioEcuacionesLineales() {
        this.a = 1;
        this.b = 1;
        this.c = 2;
        this.d = 2;
        this.e = 1;
        this.f = 2;
    }

    /**
     * Constructor de copia
     */
    public TRSergioEcuacionesLineales(int a, int b, int c, int d, int e, int f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    /**
     * Sobrescribimos el metodo equals
     * Comparamos dos ecuaciones lineales son iguales o no
     * @return true si son iguales, false si no son iguales
     */
    @Override
    public boolean equals(Object o) {
        if(this==o)
            return true;
        if(o==null) 
            return false;
        if(getClass()!=o.getClass())
            return false;

        TRSergioEcuacionesLineales eq = (TRSergioEcuacionesLineales) o;
        if (this.a==eq.a && this.b==eq.b && this.c==eq.c && this.d==eq.d && this.e==eq.e && this.f==eq.f)
            return true;
        else
            return false;
    }

    /**
     * Comprobamos si la ecuacion tiene solucion o no
     * @return true si tiene solucion, false si no tiene
     */
    public boolean tieneSolucion() {
        int aux = this.a * this.d - this.b * this.c;
        if (aux == 0)
            return false;
        else
            return true;
    }

    /**
     * Se calcula la solucion de X 
     * @return x si tiene solucion, -1 si no tiene
     */
    public double solucionX() {
        if (tieneSolucion() == true) {
            this.x = ((this.e * this.d) - (this.b * this.f)) / ((this.a * this.d) - (this.b - this.c));
            return this.x;
        } else
            return -1;
    }

    /**
     * Se calcula la solucion de y 
     * @return u si tiene solucion, -1 si no tiene
     */
    public double solucionY() {
        if (tieneSolucion() == true) {
            this.y = ((this.a * this.f) - (this.e * this.c)) / ((this.a * this.d) - (this.b - this.c));
            return this.y;
        } else
            return -1;
    }

    /**
     * Se sobrescribe el metodo el toString()
     * Saca por pantalla los valores de X e Y si tiene solucion
     * Si no tiene solucion, saca por pantalla que no hay solucion
     */
    @Override
    public String toString() {
        String salida;
        if (tieneSolucion() == true)
            salida = "Los valores son X=" + solucionX() + " y Y=" + solucionY();
        else
            salida = "No tiene solucion";
        return salida;
    }

    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private double x;
    private double y;
}