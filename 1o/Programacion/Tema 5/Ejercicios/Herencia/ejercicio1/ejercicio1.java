public class ejercicio1 {
    public static void main(String[] args) {
        Empleado e1 = new Empleado("Sergio", "Trillo", 1.7, 1200);
        System.out.println(e1.obtenerApellidos());


        Gerente g1 = new Gerente("Jose", "Fernandez", 1.8, 2500, "Finanzas");
        System.out.println(g1.obtenerApellidos());

        Tecnico t1 = new Tecnico("Pepe", "Dominguez", 1.9, 1500, 2);
        System.out.println(t1.obtenerApellidos());
    }
}
