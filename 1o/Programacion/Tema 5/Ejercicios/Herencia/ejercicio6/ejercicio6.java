public class ejercicio6 {
    public static void main(String[] args) {
        CajaCarton cc1 = new CajaCarton(3, 4, 5, "Caja Carton");
        CajaPlastico cp1 = new CajaPlastico(3, 4, 5, "Caja Plastico");

        System.out.println("Volumen caja carton: "+cc1.getVolumen());
        System.out.println("Precio caja carton: "+cc1.getPrecio()+"€");

        System.out.println("Volumen caja plastico: "+cp1.getVolumen());
        System.out.println("Precio caja plastico: "+cp1.getPrecio()+"€");
    }
}
