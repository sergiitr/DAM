import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibroDeFirmas libroDeFirmas = new LibroDeFirmas();
        libroDeFirmas.cargarFirmas(); // Cargar las firmas al iniciar el programa

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Mostrar firmas");
            System.out.println("2. Añadir nueva firma");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    libroDeFirmas.mostrarFirmas();
                    break;
                case 2:
                    System.out.print("Introduce el nombre para añadir: ");
                    String nombre = sc.nextLine();
                    libroDeFirmas.añadirFirma(nombre);
                    break;
                case 3:
                    libroDeFirmas.guardarFirmas(); // Guardar firmas antes de salir
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 3);

        sc.close();
    }
}
