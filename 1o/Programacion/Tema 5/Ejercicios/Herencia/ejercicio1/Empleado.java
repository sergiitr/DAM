class Empleado extends Persona {
    public Empleado(String nombre, String apellidos, double estatura, double salario) {
        super(nombre, apellidos, estatura);
        this.salario = salario;
    }
    public Empleado(String nombre, String apellidos, double salario) {
        super(nombre, apellidos);
        this.salario = salario;
    }
    public String obtenerApellidos() {
        String _apellidos = "Apellidos empleado: "+super.apellidos;
        return _apellidos;
    }
    public double salario;
}