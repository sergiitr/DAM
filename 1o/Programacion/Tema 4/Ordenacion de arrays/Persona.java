class Persona {
    /**
     * Constructor por defecto
     */
    public Persona(){
        this.nombre="Prueba2";
        this.edad=12;
    }

    /**
     * Constructor de copia
     * @param nombre
     * @param edad
     */
    public Persona(String nombre, int edad){
        this.nombre=nombre;
        this.edad=edad;
    }

    /**
     * Ponemos los setters de los parametros
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Ponemos los getters de los parametros
     */
    public String getNombre(){
        return nombre;
    }    
    public int getEdad() {
        return edad;
    }

    /**
     * Ponemos los atributos 
     */
    private String nombre;
    private int edad;
    
}
