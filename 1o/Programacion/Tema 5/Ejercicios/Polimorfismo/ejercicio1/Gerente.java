public class Gerente extends Empleado {
    public Gerente(String nombre, String departamento) {
        super(nombre);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    @Override
    public void trabajar() {
        System.out.println("Hola, soy "+super.nombre+" y trabajo de Gerente del departamento de "+departamento);
    }

    private String departamento;
}
