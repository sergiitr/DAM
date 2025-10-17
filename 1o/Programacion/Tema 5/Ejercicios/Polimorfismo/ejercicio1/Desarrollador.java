public class Desarrollador extends Empleado{
    public Desarrollador(String nombre, String lenguaje) {
        super(nombre);
        this.lenguaje = lenguaje;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    @Override
    public void trabajar() {
        System.out.println("Trabajo de Desarrollador con el lenguaje "+lenguaje);
    }

    private String lenguaje;
}