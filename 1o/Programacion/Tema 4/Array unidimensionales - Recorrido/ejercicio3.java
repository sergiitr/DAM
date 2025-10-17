import java.util.Random;
import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random(); 
        final int CANTNUMEROS = 10;

        int[] vectorNumeros = new int[CANTNUMEROS];
        for (int i=0; i<CANTNUMEROS; i++) {
            vectorNumeros[i] = ran.nextInt(1,10);
        }
        for (int i=0; i<CANTNUMEROS; i++){
            System.out.println("--- Numero "+i+" del vector ---");
            System.out.println("Numero: "+vectorNumeros[i]);
            System.out.println("Numero al cuadrado: "+vectorNumeros[i]*vectorNumeros[i]);
            System.out.println("Numero al cubo: "+(int)Math.pow(vectorNumeros[i], 3));
        }
    }
}
