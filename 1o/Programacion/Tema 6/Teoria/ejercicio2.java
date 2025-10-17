import java.util.ArrayList;

public class ejercicio2 {
    public static void main(String[] args) {
        Personas p1 = new Personas("Sergio", 23, "11111111A");
        Personas p2 = new Personas("Jose", 25, "22222222B");
        Personas p3 = new Personas("David", 21, "33333333C");
        Personas p4 = new Personas("Hugo", 22, "44444444D");
        ArrayList<Personas> lista = new ArrayList<>();

        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);

        System.out.println("Nuestra lista es: \n"+lista);
        
        lista.sort(null);

        System.out.println("Lista ordenada: \n"+lista);
    }
}
