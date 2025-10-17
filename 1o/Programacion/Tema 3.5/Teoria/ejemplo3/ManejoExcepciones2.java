import java.util.Scanner;

public class ManejoExcepciones2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        boolean valor=false;
        do { 
            try {
                System.out.println("Ingrese un número entero: ");
                numero = sc.nextInt();
                if (numero<0)
                    throw new IllegalArgumentException("numero no valido");
                System.out.println("Número ingresado: " + numero);
                valor=true;
            } catch (java.util.InputMismatchException e) {
                sc.nextLine();
                System.err.println("Error: Has ingresado una cadena de caracteres o un numero con decimales");
            } catch (IllegalArgumentException e1) {
                System.err.println("Error: Has ingresado un numero negativo");
            }
        } while (valor != true);
    }
}
