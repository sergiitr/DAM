class Persona {
    public Persona(String nombre, String apellidos, double estatura) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.estatura = estatura;
    }
    public Persona(String nombre, String apellidos ) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    protected String nombre;
    protected String apellidos;
    protected double estatura;
}