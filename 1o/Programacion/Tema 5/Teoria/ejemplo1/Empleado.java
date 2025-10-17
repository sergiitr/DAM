class Empleado extends Persona {
    public Empleado(String nombre, String apellidos, double estatura, double salario) {
        // Llamada al constructor de la clase padre (Persona)
        super(nombre, apellidos, estatura);
        this.salario = salario;
    }
    public Empleado(String nombre, String apellidos, double salario) {
        // Llamada al constructor de la clase padre (Persona)
        super(nombre, apellidos);
        this.salario = salario;
    }
    public double salario;
}