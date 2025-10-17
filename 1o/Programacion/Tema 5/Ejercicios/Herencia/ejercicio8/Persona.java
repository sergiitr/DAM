
public class Persona {
    public Persona(String nombre_completo, int fechaNacimiento, String DNI) {
        this.nombre_completo = nombre_completo;
        this.fechaNacimiento = fechaNacimiento;
        try {
            if (DNI.length()==9) 
                this.DNI=DNI;
            else
                throw new IllegalArgumentException("DNI introducido no valido");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    protected String nombre_completo;
    protected int fechaNacimiento;
    protected String DNI;
}