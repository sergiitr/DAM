public class Tecnico extends Empleado {
    public Tecnico(String dni, String nombre, String apellidos, double sueldoBase, int categoria) {
        super(dni, nombre, apellidos, sueldoBase);
        this.categoria=categoria;
    }
    
    @Override
    public double getSueldo() {
        return sueldoBase+sueldoBase*categoria/100;
    }

    
    private int categoria;
}
