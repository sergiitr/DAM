import java.util.Scanner;
public class sueldos{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
       	int contador=0;
       	int[] vector= new int[10];
       	System.out.println("Introduzca 10 salarios: ");
		for(int i=0; i<10; i++) {
			vector[i]=sc.nextInt();
			contador+=vector[i];
		}
		
		System.out.println("La suma de los 10 salarios: "+contador);
		
		for(int i=0; i<10; i++)
			if (vector[i] >= 1000)
				System.out.println("El salario del trabajador "+(i+1)+" es mayor que 1000€ (cobra "+vector[i]+"€)");
	}
}
