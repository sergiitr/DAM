import java.util.Scanner;

class ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cantNumeros, suma=0;
        System.out.println("Introduce el numero de numeros del vector: ");
        cantNumeros = sc.nextInt();

        int[] vector = new int[cantNumeros];

        for (int i=0; i<cantNumeros; i++) {
            System.out.println("Introduce v["+i+"]");
            vector[i] = sc.nextInt();
        }

        for (int i=0; i<cantNumeros; i++) {
            System.out.println("v["+i+"]="+vector[i]);
            suma +=vector[i];
        }
        System.out.println("La suma de los valores es: "+suma);
    }
}