import java.util.Scanner;

public class ejercicio1 {
    static boolean esPrimo(int numero) {
        boolean valor=false;
        int contador=0;
        for (int i=2;i<numero; i++) {
            if (numero%i == 0 && numero!=i) {
                contador+=1;
            }
        }
        if (contador==0) {
            valor=true;
        }
        return valor;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num;
        System.out.print("Introduce un numero: ");
        num=sc.nextInt();

        if(esPrimo(num)==true)
            System.out.println("El numero es primo");
        else
            System.out.println("El numero no es primo");
    }
}
