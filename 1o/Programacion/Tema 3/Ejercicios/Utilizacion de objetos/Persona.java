import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
class Persona {
    /**
     * Constructor por defecto
     */
    public Persona(){
        this.nombre="Prueba2";
        this.apellidos="Apellidos2";
        this.fNac=LocalDate.of(2024, 12, 12);
    }

    /**
     * Constructor de copia para el ejercicio 3
     * @param nombre
     * @param apellidos
     * @param fnac
     */
    public Persona(String nombre, String apellidos, LocalDate fnac){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.fNac=fnac;
    }
    
    /**
     * Constructor de copia para el ejercicio 4
     * @param nombre
     * @param apellidos
     */
    public Persona(String nombre, String apellidos){
        this.nombre=nombre;
        this.apellidos=apellidos;
    }

    /**
     * Comprobamos si ambos objetos son iguales o no con ==
     * @param p2 de tipo Persona
     * @return true si son iguales false si son distintos
     */
    public boolean comparador(Persona p2) {
        if(this.nombre == p2.nombre && this.apellidos == p2.apellidos && this.fNac == p2.fNac)
            return true;
        else
            return false;
    }

    /**
     * Comprobamos si ambos objetos son iguales o no con el metodo equals
     * @param p2 de tipo Persona
     * @return true si son iguales false si son distintos
     */
    @Override
    public boolean equals(Object o) {
        Persona p2 = (Persona) o;
        if(this.nombre.equals(p2.nombre) && this.apellidos.equals(p2.apellidos) && this.fNac.equals(p2.fNac))
            return true;
        else
            return false;
    }

    /**
     * Ponemos los setters de los parametros
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFNac(LocalDate fNac) {
        this.fNac = fNac;
    }

    /**
     * Ponemos los getters de los parametros
     */
    public String getNombre(){
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public LocalDate getfNac() {
        return fNac;
    }

    /**
     * Ponemos los atributos 
     */
    private String nombre;
    private String apellidos;
    private LocalDate fNac;
}
