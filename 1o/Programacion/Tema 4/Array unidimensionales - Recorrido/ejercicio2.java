import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int CANTNUMEROS = 5;

        int[] vector = new int[CANTNUMEROS];
        for (int i=0; i<CANTNUMEROS; i++) {
            System.out.println("Introduce v["+i+"]");
            vector[i] = sc.nextInt();
        }
        
        int[] vector2 = new int[CANTNUMEROS];
        for (int i=(CANTNUMEROS-1);i>=0; i--) {
            for (int j=0; j<CANTNUMEROS; j++) {
                vector2[j] = vector[i];
                i--;
            }
        }
        System.out.println("Vector 1");
        for (int i=0; i<CANTNUMEROS; i++) 
            System.out.println(vector[i]);
        
        System.out.println("Vector 2");
        for (int i=0; i<CANTNUMEROS; i++) 
            System.out.println(vector2[i]);
        

        // Solucion sin segundo vector
        System.out.println("\n\nVector antes del cambio");
        for (int i=0; i<CANTNUMEROS; i++) 
            System.out.println(vector[i]);
        
        int aux=0;
        System.out.println("Vector despues del cambio");
        for (int i=0; i<(CANTNUMEROS-1); i++) {
            for (int j=i+1; j<CANTNUMEROS;j++){
                aux=vector[i];
                vector[i]=vector[j];
                vector[j]=aux;
            }
        }
        for (int i=0; i<CANTNUMEROS; i++) 
            System.out.println(vector[i]);
        
    }
}
