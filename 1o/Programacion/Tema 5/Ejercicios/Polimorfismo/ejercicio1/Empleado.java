public class Empleado {
    public Empleado(String nombre) {
        if (contadorEmpleados < MAX_EMPLEADOS) {
            this.nombre = nombre;
            empleados[contadorEmpleados] = this;
            contadorEmpleados++;
            System.out.println("Empleado " + nombre + " creado con éxito.");
        } else {
            System.out.println("Limite excedido de empleados.");
        }
    }

    public void trabajar() {
        System.out.println();
    }

    protected String nombre;
    private final int MAX_EMPLEADOS = 10;
    Empleado[] empleados = new Empleado[MAX_EMPLEADOS];
    private int contadorEmpleados = 0;
}
