public abstract class Empleado {
    public Empleado(String dni, String nombre, String apellidos, double sueldoBase) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sueldoBase = sueldoBase;
    }
    
    public String getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public double getSueldoBase() {
        return sueldoBase;
    }
    
    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public double getSueldo() {
        return sueldo;
    }

    @Override
    public String toString() {
        return "Empleado [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", sueldoBase=" + sueldoBase + "€, sueldo="+getSueldo()+"€]";
    }

    protected String dni;
    protected String nombre;
    protected String apellidos;
    protected double sueldoBase;
    protected double sueldo;
}
