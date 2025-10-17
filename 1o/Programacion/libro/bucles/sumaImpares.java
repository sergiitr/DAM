import java.util.Scanner;
public class sumaImpares{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
       	long contador=1, auxiliar=0, i=0;
       	
       	
       	System.out.println("Introduzca un numero: ");
       	do {
			if (i%2==1){
				contador *= i;
				auxiliar++;
			}
			i++;
		} while (auxiliar < 10);       	
		System.out.println("La suma de los primeros 10 impares es: "+contador);			
	}
}
