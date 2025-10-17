
import java.util.ArrayList;

public class ejercicio1 {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Tarea 1");
        lista.add("Tarea 2");
        lista.addLast("Tarea al final de la lista");
        
        System.out.println("La lista es: "+ lista);
        
        lista.remove(1);

        System.out.println("La lista actualizada es: "+ lista);

        System.out.println(lista.get(1));

        lista.add("ccc");
        lista.add("dddd");
        lista.add("zzz");
        lista.add("yyyyyy");
        lista.add("Aaaaa");

        System.out.println("La lista ordenada es: ");
        lista.sort(null);
        System.out.println(lista);
    }
}
