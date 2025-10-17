public abstract class FiguraGeometrica {
    public FiguraGeometrica(String nombre) {
        this.nombre = nombre;
    }

    abstract void calcularArea();
    abstract void calcularPerimetro();

    protected String nombre;
}