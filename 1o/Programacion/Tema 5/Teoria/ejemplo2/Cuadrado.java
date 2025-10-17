public class Cuadrado extends FiguraGeometrica {
    public Cuadrado(int long_Lado, String nombre) {
        super(nombre);
        this.long_Lado = long_Lado;
    }

    @Override
    public void calcularArea() {
        int resultado = long_Lado*long_Lado;
        System.out.println("El area del cuadrado es: "+resultado);
    }

    @Override
    public void calcularPerimetro() {
        int resultado = long_Lado*4;
        System.out.println("El area del cuadrado es: "+resultado);
    }

    private int long_Lado;
    private String nombre;
}