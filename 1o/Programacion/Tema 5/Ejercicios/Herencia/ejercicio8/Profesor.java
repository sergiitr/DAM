
public class Profesor extends Persona {
    public Profesor(String nombre_completo, int fechaNacimiento, String DNI, String especialidad) {
        super(nombre_completo, fechaNacimiento, DNI);
        try {
            if (especialidad.toLowerCase().equals("matematicas") || especialidad.toLowerCase().equals("inglés") || especialidad.toLowerCase().equals("lengua y literatura") || especialidad.toLowerCase().equals("física y química") || especialidad.toLowerCase().equals("informática") || especialidad.toLowerCase().equals("educación física"))
                this.especialidad = especialidad;
            else
                throw new IllegalArgumentException("Especialidad no válida: " + especialidad);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Profesor [nombre_completo=" + nombre_completo + ", fechaNacimiento=" + fechaNacimiento + ", especialidad=" + especialidad + "]";
    }

    

    protected String especialidad;
}
