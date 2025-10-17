
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();
        boolean auxiliar=true;

        do { 
            String dni, nombre;
            int tlfn, aux=0;
            System.out.print("Introduzca DNI: ");
            dni=sc.nextLine();
            System.out.print("Introduzca nombre: ");
            nombre=sc.nextLine();
            System.out.print("Introduzca tlfn: ");
            tlfn=sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < clientes.size(); i++)
                if (clientes.get(i).getDNI().equals(dni))
                    aux++;
            
            if(aux==0) {
                Cliente c = new Cliente(dni,nombre,tlfn);
                clientes.add(c);
            } else 
                auxiliar=false;
        } while (auxiliar);

        System.out.println(clientes);
    }
}
