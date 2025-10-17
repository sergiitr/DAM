public class ejercicio5 {
    public static void main(String[] args) {
        Caja c1 = new Caja(3, 4, 5, "Caja1");
        CajaCarton cc1 = new CajaCarton(3, 4, 5, "Caja Carton");

        System.out.println("Volumen caja: "+c1.getVolumen());
        System.out.println("Volumen caja carton: "+cc1.getVolumen());
        System.out.println("Precio caja: "+c1.getPrecio()+"€");
        System.out.println("Precio caja carton: "+cc1.getPrecio()+"€");
    }
}
