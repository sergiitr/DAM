public class Cilindro2 {
    /**
     * Valor de PI
     */
    public final static double PI = 3.14;

    /**
     * Constructores
     */
    public Cilindro2() {
        this.altura = 2;
        this.radio = 2;
    }
    public Cilindro2(int altura, int radio) {
        this.altura = altura;
        this.radio = radio;
    }

    /**
     * Setters
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }
    public void setRadio(int radio) {
        this.radio = radio;
    }
    
    /**
     * Getters
     */
    public int getAltura() {
        return altura;
    }
    public int getRadio() {
        return radio;
    }

    /**
     * Se calcula la superficie del Cilindro2
     * La formula que se utiliza es: 2πhr+2πr²
     * @return superficie
     */
    public double getSuperficie() {
        superficie = (2 * PI * altura * radio) + (2 * PI * radio * radio);
        return superficie;
    }

    /**
     * Se calcula el volumen del Cilindro2
     * La formula que se utiliza es: πr²h
     * @return volumen
     */
    public double getVolumen() {
        volumen = PI * radio * radio * altura;
        return volumen;
    }

    /**
     * Métodos estáticos para calcular superficie y volumen sin necesidad de instanciar la clase
     */
    public static double calcularSuperficie(int altura, int radio) {
        return (2 * PI * altura * radio) + (2 * PI * radio * radio);
    }

    public static double calcularVolumen(int altura, int radio) {
        return PI * radio * radio * altura;
    }

    /**
     * Método toString
     */
    @Override
    public String toString() {
        return "Cilindro2 [altura=" + altura + "cm, radio=" + radio + "cm, Superficie=" + getSuperficie() + "cm2, Volumen=" + getVolumen() + "cm3]";
    }

    /**
     * Atributos
     */
    private int altura;
    private int radio;
    private double superficie;
    private double volumen;
}