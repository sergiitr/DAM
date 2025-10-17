import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Scanner sc = new Scanner(System.in);
        ArrayList<Coche> coches = new ArrayList<>();
        boolean acabar=true;
        String marca, modelo, matricula;
        do {
            System.out.print("Introduce matricula (FIN para acabar): ");
            matricula = sc.nextLine();
            System.out.print("Introduce marca: ");
            marca = sc.nextLine();
            System.out.print("Introduce modelo: ");
            modelo = sc.nextLine();

            if (!matricula.equals("FIN")) {
                Coche c1 = new Coche(matricula, marca, modelo);
                coches.add(c1);
            } else {
                acabar=false;
            }
        } while (acabar==true);
        String _coches =  gson.toJson(coches);
        System.out.println(_coches);
    }
}
