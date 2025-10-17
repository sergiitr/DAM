public class Persona implements Comparable<Persona>{

    public Persona(String nombre, int edad, String ciudad) {
        this.ciudad = ciudad;
        this.edad = edad;
        this.nombre = nombre;
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
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public int compareTo(Persona otraPersona) {
        if (this.edad>otraPersona.edad)
            return 1;
        else if (this.edad<otraPersona.edad)
            return -1;
        else
            return 0;
    }
    private String nombre;
    private int edad;
    private String ciudad;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("nombre=").append(nombre);
        sb.append(", edad=").append(edad);
        sb.append(", ciudad=").append(ciudad);
        sb.append('}');
        return sb.toString();
    }
}
