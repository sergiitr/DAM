import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca la frase: ");
        String frase = sc.nextLine();

        frase = frase.toLowerCase();
        int[] contador = new int[26];

        for (int i = 0; i < frase.length(); i++) {
            char caracter = frase.charAt(i);
            if (caracter >= 'a' && caracter <= 'z') 
                contador[caracter - 'a']++;  
        }
        for (int i = 0; i < contador.length; i++) 
            if (contador[i] > 0) 
                System.out.println((char) (i + 'a') + ": " + contador[i]);
    }
}
