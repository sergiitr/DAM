import java.util.Random;
import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int tamano;
        /**
         * Inicializamos una cadena de caracteres
         */
        String cadenaCaracteres="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyx0123456789";
        
        /**
         * Inicializamos el valor de la longitud de la contraseña
         */
        System.out.println("Introduzca el tamaño de la cadena:");
        tamano=sc.nextInt();
        
        /**
         * Inicializamos un vector del tamaño introducido donde se ira guardando caracter a caracter
         */
        char[] miContrasena = new char[tamano];

        /**
         * Se van generando cada uno de los caracteres de la contraseña y se van guardando en nuestra cadena
         */
        for (int i=0; i<tamano;i++)
            miContrasena[i] = cadenaCaracteres.charAt(r.nextInt(cadenaCaracteres.length()));
        
        /**
         * Mostramos x pantalla mi contraseña generada
         */
        System.out.println("Mi contraseña es: ");
        for (int i=0; i<tamano;i++)
            System.out.print(miContrasena[i]);
        
        System.out.println();
    }
}