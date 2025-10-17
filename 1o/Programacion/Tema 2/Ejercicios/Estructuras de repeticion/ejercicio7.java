import java.util.Scanner;
public class ejercicio7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
       	int numero, contador=0;
       	
       	System.out.println("Introduzca el numero : ");
       	numero=sc.nextInt();
       	for (int i=1; i<=numero; i++) 
			if (numero%i==0) {
				contador++;
				System.out.println("Es divisible entre "+i);
			}
		
		if (contador > 2)
			System.out.println("No es primo");
		else 
			System.out.println("Es primo");
	}
}
