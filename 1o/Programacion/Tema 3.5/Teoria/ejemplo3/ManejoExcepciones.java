import java.util.Scanner;

public class ManejoExcepciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean valor=false;
        do { 
            try {
                System.out.println("Ingrese un número entero: ");
                int numero = scanner.nextInt();
                System.out.println("Número ingresado: " + numero);
                valor=true;
            } catch (java.util.InputMismatchException e) {
                scanner.nextLine();
                System.err.println("Error: Ingrese un número entero válido.");
            }
        } while (valor != true);
        System.out.println("Programa finalizado.");
    }
}
