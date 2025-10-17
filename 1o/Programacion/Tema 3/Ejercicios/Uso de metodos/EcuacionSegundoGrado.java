public class EcuacionSegundoGrado {
    /**
     * Constructor x defecto
     */
    public EcuacionSegundoGrado() {
        this.a = 1;
        this.b = 5;
        this.c = 5;
    }
    /**
     * Constructor de copia
     * @param a
     * @param b
     * @param c
     */
    public EcuacionSegundoGrado(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
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

    /**
     * Solucion positiva
     */
    public double solucion1() {
        x1 =(-this.b+Math.sqrt(this.b*this.b-4*this.a*this.c))/(2*this.a);
        return x1;
    }
    /**
     * Solucion negativa
     */
    public double solucion2() {
        x2 =(-this.b-Math.sqrt(this.b*this.b-4*this.a*this.c))/(2*this.a);
        return x2;
    }

    /**
     * Sobrescribimos el metodo toString()
     * Se mostrara la solucion positiva y negativa de la ecuación de segundo grado
     */
    @Override
    public String toString() {
        return "Las soluciones de esta ecuación son " + solucion1() + " y " + solucion2();
    }

    private double x1;
    private double x2;
    private int a;
    private int b;
    private int c;
}