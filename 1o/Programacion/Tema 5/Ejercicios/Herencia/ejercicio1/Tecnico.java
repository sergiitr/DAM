public class Tecnico extends Empleado {
    public Tecnico(String nombre, String apellidos, double estatura, double salario, int nivel) {
        super(nombre, apellidos, estatura, salario);
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String obtenerApellidos() {
        String _apellidos = "Apellidos tecnico: "+super.apellidos;
        return _apellidos;
    }

    private int nivel;
}
