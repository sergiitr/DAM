public class Main {
    public static void main(String[] args) {
        Cuadrado c1 = new Cuadrado(5, "Cuadrado");
        TrianguloRectangulo t1 = new TrianguloRectangulo(3, 4, "Triangulo");

        c1.calcularArea();
        c1.calcularPerimetro();

        t1.calcularArea();
        t1.calcularPerimetro();
    }
}