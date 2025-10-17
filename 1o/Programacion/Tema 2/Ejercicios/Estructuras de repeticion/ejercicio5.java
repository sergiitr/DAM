import java.util.Scanner;
public class ejercicio5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
       	int numero;
       	
       	System.out.println("Introduzca el numero : ");
       	numero=sc.nextInt();
       	
       	for (int i=numero; i>0; i--) {
			if (numero%i==0)
				System.out.println("El numero "+i+" es divisor de "+numero);
		}
	}
}
