public class Estudiante {
    /**
     * Constructor por defecto
     */
    public Estudiante(){
        this.nombre="Prueba2";
        this.nota=6;
    }

    /**
     * Constructor de copia
     * @param nombre
     * @param nota
     */
    public Estudiante(String nombre, int nota){
        this.nombre=nombre;
        this.nota=nota;
    }
    /**
     * Ponemos los setters de los parametros
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setNota(int nota) {
        this.nota = nota;
    }

    /**
     * Ponemos los getters de los parametros
     */
    public String getNombre(){
        return nombre;
    }    
    public int getNota() {
        return nota;
    }

    /**
     * Ponemos los atributos 
     */
    private String nombre;
    private int nota;
}
