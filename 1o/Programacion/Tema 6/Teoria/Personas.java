public class Personas implements Comparable<Personas>{
    public Personas(String nombre, int edad, String dNI) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = dNI;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getDNI() {
        return DNI;
    }
    public void setDNI(String dNI) {
        DNI = dNI;
    }

    @Override
    public String toString() {
        return "Personas [nombre=" + nombre + ", edad=" + edad + ", DNI=" + DNI + "]";
    }

    @Override
    public int compareTo(Personas otraPersona) {
        if (this.edad>otraPersona.edad)
            return 1;
        else if (this.edad<otraPersona.edad)
            return -1;
        else
            return 0;

    }
    private String nombre;
    private int edad;
    private String DNI;
}
