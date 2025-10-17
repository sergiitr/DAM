public class Empleado {
    public Empleado() {
        this.nombre="nombre x defecto";
        this.apellidos="apellidos x defecto";
        this.dni="11111111A";
        this.edad=18;
        this.sueldo=1000;
    }
    public Empleado(String dni, String nombre, String apellidos, int edad, int sueldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.sueldo = sueldo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String nombreCompleto() {
        String nombreCompleto = this.nombre+" "+this.apellidos;
        return nombreCompleto;
    }

    String dni;
    String nombre;
    String apellidos;
    int edad;
    int sueldo;
}