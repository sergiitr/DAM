import java.util.Random;
import java.util.Scanner;

public class ejercicio6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random r=new Random();
        int tam1, tam2;
        System.out.println("introduce el tamaño del arrayPrimero: ");
        tam1=sc.nextInt();
        System.out.println("introduce el tamaño del arraySegundo: ");
        tam2=sc.nextInt();
        
        int[] arrayPrimero=new int[tam1];
        int[] arraySegundo=new int[tam2];

        for (int i=0; i<tam1; i++)
            arrayPrimero[i]=r.nextInt();
        
        for (int i=0; i<tam2; i++)
            arraySegundo[i]=r.nextInt();
        
        final int LONGITUD_COMBINADO=arrayPrimero.length + arraySegundo.length;
        int[] arrayCombinado=new int[LONGITUD_COMBINADO];

        if (arraySegundo.length>arrayPrimero.length) {
            // Asignar elementos de arrayPrimero en las posiciones pares de arrayCombinado
            int j=0;
            for (int i=0; i<arrayPrimero.length; i++) {
                arrayCombinado[j]=arrayPrimero[i];
                j+=2;
            }

            // Asignar elementos de arraySegundo en las posiciones impares de arrayCombinado
            int k=1;
            for (int i=0; i<arrayPrimero.length; i++) {
                arrayCombinado[k]=arraySegundo[i];
                k+=2;
            }

            // Asignar los elementos restantes de arraySegundo en las posiciones libres
            for (int i=(arrayPrimero.length * 2); i<arrayCombinado.length; i++) 
                arrayCombinado[i]=arraySegundo[i-arrayPrimero.length];
        } else {
            // Asignar elementos de arraySegundo en las posiciones impares de arrayCombinado
            int k=1;
            for (int i=0; i<arraySegundo.length; i++) {
                arrayCombinado[k]=arraySegundo[i];
                k+=2;
            }

            // Asignar elementos de arrayPrimero en las posiciones pares de arrayCombinado
            int j=0;
            for (int i=0; i<arraySegundo.length; i++) {
                arrayCombinado[j]=arrayPrimero[i];
                j+=2;
            }

            // Asignar los elementos restantes de arrayPrimero en las posiciones libres
            for (int i=(arraySegundo.length * 2); i<arrayCombinado.length; i++) 
                arrayCombinado[i]=arrayPrimero[i-arraySegundo.length];
        }

        //array1
        System.out.print("arrayPrimero[");
        for (int i=0; i<tam1; i++) 
            System.out.print(arrayPrimero[i] + " ");
        System.out.println("]");

        //array2
        System.out.print("arraySegundo[");
        for (int i=0; i<tam2; i++) 
            System.out.print(arraySegundo[i] + " ");
        System.out.println("]");

        // Mostrar el array combinado
        System.out.print("arrayCombinado[");
        for (int i=0; i<LONGITUD_COMBINADO; i++) 
            System.out.print(arrayCombinado[i] + " ");
        System.out.println("]");
    }
}
