class Gerente extends Empleado {
    public Gerente(String nombre, String apellidos, double estatura, double salario, String departamento) {
        super(nombre, apellidos, estatura, salario);
        this.departamento = departamento;
    }
    
    public String getDepartamento() {
        return departamento;
    }
    
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String obtenerApellidos() {
        String _apellidos = "Apellidos gerente: "+super.apellidos;
        return _apellidos;
    }

    private String departamento;
}
