public class ProfesorTitular extends Profesor {
    public ProfesorTitular(String nombre_completo, int fechaNacimiento, String DNI, String especialidad, int anio_incorporacion) {
        super(nombre_completo, fechaNacimiento, DNI, especialidad);
        try {
            if (anio_incorporacion<=2025 || anio_incorporacion>=1900)
                this.anio_incorporacion = anio_incorporacion;
            else
                throw new IllegalArgumentException("Año no válido: " + anio_incorporacion);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getAnio_incorporacion() {
        return anio_incorporacion;
    }

    public void setAnio_incorporacion(int anio_incorporacion) {
        this.anio_incorporacion = anio_incorporacion;
    }

    private int anio_incorporacion;

}
