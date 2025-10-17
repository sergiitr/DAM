import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase principal que simula una partida de un juego de pociones.
 * Crea pociones sanadoras y venenosas, las añade a un inventario,
 * las baraja, las vende y muestra el inventario final.
 * @author JMProf
 */
public class Partida {
    public static void main(String[] args) {

        // Crear arrays de ingredientes para pociones
        String[] ingredientesPocionSanadora = {"romero druídico", "terraria"};
        String[] ingredientesPocionVenenosa = {"seta apestosa", "seta apestosa", "terraria"};

        // Crear pociones sanadoras
        PocionSanadora pocionSanadora1 = new PocionSanadora("Sanadora", Potencia.FUERTE, ingredientesPocionSanadora);
        PocionSanadora pocionSanadora2 = new PocionSanadora("Sanadora", Potencia.MEDIA, ingredientesPocionSanadora);
        PocionSanadora pocionSanadora3 = new PocionSanadora("Sanadora", Potencia.DEBIL, ingredientesPocionSanadora);

        // Crear pociones venenosas
        PocionVenenosa pocionVenenosa1 = new PocionVenenosa("Venenosa", Potencia.FUERTE, ingredientesPocionVenenosa);
        PocionVenenosa pocionVenenosa2 = new PocionVenenosa("Venenosa", Potencia.DEBIL, ingredientesPocionVenenosa);

        // Añadir pociones al inventario
        ArrayList<Pocion> inventario = new ArrayList<>();

        inventario.add(pocionSanadora1);
        inventario.add(pocionSanadora2);
        inventario.add(pocionSanadora3);
        inventario.add(pocionVenenosa1);
        inventario.add(pocionVenenosa2);

        // Barajar inventario
        Collections.shuffle(inventario);

        // Mostrar inventario
        mostrarInventario(inventario);

        // Vender pociones
        System.out.println("Vendiendo pociones:");
        System.out.println("\n-------------------\n");
        for (int i = 0; i < 3; i++) {
            Pocion pocion = inventario.get(0);
            System.out.println(pocion.mostrarDescripcion());
            pocion.regatear();
            System.out.println("Poción vendida por " + pocion.vender() + " monedas");
            inventario.remove(pocion);
            System.out.println("\n-------------------\n");
        }

        // Ordenar inventario
        inventario.sort(null);

        // Mostrar inventario
        mostrarInventario(inventario);
    }

    /**
     * Muestra el inventario de pociones haciendo un recuento de pociones sanadoras
     * y venenosas.
     * @param inventario ArrayList de pociones a mostrar.
     */
    public static void mostrarInventario(ArrayList<Pocion> inventario) {
        System.out.println("Inventario actual:");
        System.out.println(inventario);

        int sanadoras = 0;
        int venenosas = 0;

        for (Pocion p : inventario) {
            if (p instanceof PocionSanadora) {
                sanadoras++;
            } else if (p instanceof PocionVenenosa) {
                venenosas++;
            }
        }

        System.out.println("Pociones sanadoras: " + sanadoras);
        System.out.println("Pociones venenosas: " + venenosas);
        System.out.println("\n-------------------\n");
    }
}