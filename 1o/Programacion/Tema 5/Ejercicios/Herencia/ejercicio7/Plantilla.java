public class Plantilla {
    public Plantilla() { }

    public void contratarEmpleado(Empleado empleado) {
        if (contador<PERSONAL)
            empleados[contador++] = empleado;
        else
            System.out.println("No se pueden agregar más empleados. Limite alcanzado.");
    }

    public void getEmpleadosPorNombre(String nombre) {
        int cont=0;
        for (int i=0; i<contador; i++)
            if (empleados[i].getNombre().equals(nombre)){
                System.out.println(empleados[i].toString());
                cont++;
            }
        
        if(cont==0)
            System.out.println("No hay empleados con el nombre "+nombre);
    }
    private static final int PERSONAL = 10;
    private Empleado[] empleados = new Empleado[PERSONAL];
    private int contador = 0;

}
