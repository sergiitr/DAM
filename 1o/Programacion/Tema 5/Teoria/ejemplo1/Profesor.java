class Profesor extends Empleado {
    public Profesor(String nombre, String apellidos, double sueldo, String materia) {
        super(nombre, apellidos, sueldo);
        this.materia = materia;
    }
    
    public String getMateria() {
        return materia;
    }
    public void setMateria(String materia) {
        this.materia = materia;
    }


    protected String materia;
}
