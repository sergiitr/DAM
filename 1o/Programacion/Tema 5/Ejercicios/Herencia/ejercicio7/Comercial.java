public class Comercial extends Empleado {
    public Comercial(String dni, String nombre, String apellidos, double sueldoBase) {
        super(dni, nombre, apellidos, sueldoBase);
    }

    public void setVentas(double ventas) {
        this.ventas = ventas;
    }
    
    @Override
    public double getSueldo() {
        return sueldoBase+ventas*10/100;
    }

    private double ventas;
}
