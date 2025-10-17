public class TrianguloRectangulo extends FiguraGeometrica {
    public TrianguloRectangulo(int lado1, int lado2, String nombre) {
        super(nombre);
        this.lado1 = lado1;
        this.lado2 = lado2;
    }
    

    @Override
    public void calcularArea() {
        double resultado = (double)(lado1+lado2)/2;
        System.out.println("El area del Triangulo es: "+resultado);
    }
    @Override
    public void calcularPerimetro() {
        double resultado = (double)lado1+lado2+hipotenusa();
        System.out.println("El area del Triangulo es: "+resultado);
    }

    private double hipotenusa() {
        double hipotenusa = Math.sqrt(lado1*lado1+lado2*lado2);
        return hipotenusa;
    }
    private int lado1;
    private int lado2;
    private String nombre;
}
