
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    /**
     * Codigo para mostrar el inventario de pociones
     * @param inventario
     */
    public static void mostrarInventario(ArrayList<Pocion> inventario) {
        System.out.println("Nuestras pociones son: "+inventario);

        int contadorVenenosa=0, contadorSenadora=0;

        // Contamos cuantas pociones hay de cada tipo
        for (int i = 0; i < inventario.size(); i++) {
            if(inventario.get(i).getNombre().toLowerCase().equals("venenosa")){
                contadorVenenosa++;
            } else if(inventario.get(i).getNombre().toLowerCase().equals("senadora")){
                contadorSenadora++;
            }
        }
        System.out.println("\nHay "+contadorVenenosa+" venenosa y " +contadorSenadora+" senadora");
    }


    public static void main(String[] args) {
        String[] ingredientesSenadora = new String[2];
        ingredientesSenadora[0] = "Romero druidico";
        ingredientesSenadora[1] = "Terraria";

        String[] ingredientesPocionVenenosa = new String[2];
        ingredientesPocionVenenosa[0] = "Seta apestosa";
        ingredientesPocionVenenosa[1] = "Terraria";

        ArrayList<Pocion> inventario = new ArrayList<>();
        inventario.add(new Senadora("Senadora", Potencia.FUERTE, ingredientesSenadora));
        inventario.add(new Senadora("Senadora", Potencia.DEBIL, ingredientesSenadora));
        inventario.add(new Senadora("Senadora", Potencia.MEDIA, ingredientesSenadora));

        inventario.add(new PocionVenenosa("Venenosa", Potencia.DEBIL, ingredientesPocionVenenosa));
        inventario.add(new PocionVenenosa("Venenosa", Potencia.FUERTE, ingredientesPocionVenenosa));
        
        Collections.shuffle(inventario);

        mostrarInventario(inventario);
        System.out.println();
        System.out.println(inventario.get(0).descripcion());
        System.out.println("Regateando...");
        inventario.get(0).regatear();
        System.out.println("Venta: "+inventario.get(0).vender());
        inventario.remove(0);

        System.out.println(inventario.get(0).descripcion());
        System.out.println("Regateando...");
        inventario.get(0).regatear();
        System.out.println("Venta: "+inventario.get(0).vender());
        inventario.remove(0);

        System.out.println(inventario.get(0).descripcion());
        System.out.println("Regateando...");
        inventario.get(0).regatear();
        System.out.println("Venta: "+inventario.get(0).vender());
        inventario.remove(0);
        
        
        inventario.sort(null);
        mostrarInventario(inventario);
        
    }
}