public class ProfesorInterino extends Profesor{
    
    public ProfesorInterino(String nombre_completo, int fechaNacimiento, String DNI, String especialidad, int meses_contratacion) {
        super(nombre_completo, fechaNacimiento, DNI, especialidad);
        try {
            if (meses_contratacion>0)
                this.meses_contratacion = meses_contratacion;
            else
                throw new IllegalArgumentException("Meses contratacion no válido: " + meses_contratacion);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private int meses_contratacion;
}