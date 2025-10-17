public class Jugador {
    public Jugador(String nombre, int edad, double estatura) {
        this.edad = edad;
        this.estatura = estatura;
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

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    
    String nombre;
    int edad;
    double estatura;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre);
        sb.append(",   Edad: ").append(edad);
        sb.append(",   Estatura: ").append(estatura);
        return sb.toString();
    }
}
