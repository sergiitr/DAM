
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Alimento> alimentos = new ArrayList<>();

        alimentos.add(new AceiteOliva("RE101", Alimentos.ACEITE, true,Alimentos.ACEITE , IVA.REDUCIDO, "Marca", 15.0));
        alimentos.add(new Cerveza("RE100", Alimentos.LICOR, true,Alimentos.LICOR , IVA.REDUCIDO, "Cruzcampo", 3.0));
        alimentos.add(new Cerveza("RE102", Alimentos.LICOR, true,Alimentos.LICOR , IVA.REDUCIDO, "Cruzcampo", 6.0));

        System.out.println("Lista: \n"+alimentos);

        alimentos.sort(null);
        System.out.println("\n");
        System.out.println("Lista ordenada: \n"+alimentos);


    }
}
