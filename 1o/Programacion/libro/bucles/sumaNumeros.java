import java.util.Scanner;
public class sumaNumeros {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
       	int numero, contador=0;
       	
       	System.out.println("Introduzca un numero: ");
       	do{
			numero=sc.nextInt();
			contador+=numero;
		} while(numero != 0);
		System.out.println("La suma es: "+contador);			
	}
}
