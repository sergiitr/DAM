public class Principal {
    public static void main(String[] args) {
        Plantilla plantilla = new Plantilla();
        // Técnico de categoría 1
        plantilla.contratarEmpleado(new Tecnico("11111111H", "Alejandro",  "Fernández", 1000, 1));
        
        // Técnico de categoría 2
        plantilla.contratarEmpleado(new Tecnico("22222222J", "Alejandro", "Jiménez", 1000, 2));

        // Comercial
        Comercial comercial = new Comercial("33333333P", "Desiderio", "Durán", 800);
        comercial.setVentas(2000);
        
        // Técnico de categoría 2
        Comercial comercial2 = new Comercial("33333333P", "Desiderio", "Durán", 800);
        
        plantilla.contratarEmpleado(comercial);
        plantilla.contratarEmpleado(comercial2);
        
        plantilla.getEmpleadosPorNombre("er");
        System.out.println();
        plantilla.getEmpleadosPorNombre("Alejandro");
        System.out.println();
        plantilla.getEmpleadosPorNombre("Desiderio");
    }
}
